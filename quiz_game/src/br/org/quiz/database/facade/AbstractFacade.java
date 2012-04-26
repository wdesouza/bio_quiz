package br.org.quiz.database.facade;

import br.org.quiz.database.jpa.DAOTransactions;

public abstract class AbstractFacade<T> {

	protected DAOTransactions<T> dao;
	
	protected abstract DAOTransactions<T> instantiateDao();
	
	public void insert(T entity) {
		dao.insert(entity);
	}
	
	public void update(T entity) {
		dao.update(entity);
	}
	
	public void delete(T entity) {
		dao.delete(entity);
	}
	
	public T find(Object id) {
		return dao.find(id);
	}
}
