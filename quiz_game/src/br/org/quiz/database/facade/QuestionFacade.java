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
package br.org.quiz.database.facade;

import java.util.List;

import com.google.common.base.Preconditions;

import br.org.quiz.database.entity.Question;
import br.org.quiz.database.jpa.DAOTransactions;
import br.org.quiz.database.jpa.DAOTransactionsImp;
import br.org.quiz.database.util.SQLUtils;

public class QuestionFacade extends AbstractFacade<Question>{

	public QuestionFacade() {}
	
	@Override
	protected DAOTransactions<Question> instantiateDao() {
		return new DAOTransactionsImp<Question>(Question.class);
	}

	public Integer getQuestionMaxId() {
		return dao.getMax("idQuestao");
	}
	
	@Override
	public void insert(Question question) {
		checkQuestion(question);
		injectNextId(question);
		super.insert(question);
	}

	public List<Question> findQuestionsByDescription(String expression) {
		
		expression = SQLUtils.formatMatchAnyLowerCase(expression);
		return dao.executeNamedQuery("Question.search"
								   , expression);
	}
	
	private void injectNextId(Question question) {
		Integer nexId = getQuestionMaxId() + 1;
		question.setIdQuestao(nexId);
	}

	private void checkQuestion(Question question) {
		Preconditions.checkState( question.hasAnswer()
								, String.format("Não há resposta válida definida " +
								  "para a pergunta '%s'.", question.getDescricao()) );
	}
}
