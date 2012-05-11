/*
 * Copyright 2012 Matheus Binotto, Welliton de Souza
 *
 * Este arquivo é parte do programa BioQuiz
 *
 * BioQuiz é um software livre; você pode redistribui-lo e/ou 
 * modifica-lo dentro dos termos da Licença Pública Geral GNU como 
 * publicada pela Fundação do Software Livre (FSF); na versão 2 da 
 * Licença, ou (na sua opnião) qualquer versão.
 *
 * Este programa é distribuido na esperança que possa ser  util, 
 * mas SEM NENHUMA GARANTIA; sem uma garantia implicita de ADEQUAÇÂO a qualquer
 * MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a
 * Licença Pública Geral GNU para maiores detalhes.
 *
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package br.org.quiz.database.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;





/**
 * Defina as ações comuns das entidades
 * de banco de dados (inserir, deletar, atualizar, pesquisar)
 * 
 * @author matheus
 */
public class DAOTransactionsImp<T> implements DAOTransactions<T>{

	private Class<T> managedClass;
	private EntityManager manager;
	
	public DAOTransactionsImp(Class<T> managedClass) {
		
		this.manager = PersistenceConnection
							.getInstance().createManager();
		
		this.managedClass = (Class<T>) managedClass;
	}
	
	
	@Override
	public T find(Object id) {
		
		if(id == null) return null;
		T found = getManager().find(managedClass, id);
		return found;
	}
	
	@Override
	public void insert(T object) {
		initTransaction();
		getManager().persist(object);
		commit();
	}
	
	@Override
	public void update(T object) {
		initTransaction();
		getManager().merge(object);
		commit();
	}

	@Override
	public void delete(T object) {
		initTransaction();
		getManager().merge(object);
		if(object != null)
			getManager().remove(object);
		commit();
	}
	
	private EntityManager getManager() {
		return this.manager;
	}


	@Override
	public void detach(T o) {
		getManager().detach(o);
	}

	@Override
	public void rollback() {
		getManager().getTransaction().rollback();
	}

	@Override
	public void deleteById(Object id) {
		T object = getManager().find(managedClass, id);
		if(object != null)
			getManager().remove(object);
	}	

	

	@Override
	public List<T> executeNamedQuery(String queryName, Object... params) {
		
		TypedQuery<T> query = getManager().createNamedQuery(queryName, managedClass);
		fillQueryWithParams(query, params);
		return query.getResultList();
	}

	@Override
	public <K> List<K> executeNamedQuery(String queryName, Class<K> resultClass, Object... params) {
		
		TypedQuery<K> query = getManager().createNamedQuery(queryName, resultClass);
		fillQueryWithParams(query, params);
		return query.getResultList();
	}

	@Override
	public <K> K searchSingleMember(String queryName, Class<K> resultClass, Object... params) {
		try {
			TypedQuery<K> query = getManager().createNamedQuery(queryName,resultClass);
			fillQueryWithParams(query, params);
			return query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

	private void fillQueryWithParams(Query q, Object[] params) {
		for(int i=0;i<params.length;i++) {
			q.setParameter(i + 1, params[i]);
		}
	}

	@Override
	public T executeNamedQuerySingleResult(String queryName, Object... params) {
		try {
			TypedQuery<T> query = getManager().createNamedQuery(queryName, managedClass);
			fillQueryWithParams(query, params);
			return query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}


	@Override
	public void initTransaction() {
		getManager().getTransaction().begin();
	}


	@Override
	public void commit() {
		getManager().getTransaction().commit();
	}


	@Override
	public Integer getMax(String fieldName) {
		
		String jpql = String.format("SELECT MAX(t.%s) FROM %s t"
								  , fieldName
								  , managedClass.getSimpleName());
		Query query = getManager().createQuery(jpql);
		Integer result = (Integer) query.getSingleResult();
		return result == null ? 0 : result;
	}	
}
