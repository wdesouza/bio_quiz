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
package br.org.quiz.controller;

import java.util.List;

import br.org.quiz.database.entity.Choice;
import br.org.quiz.database.entity.Question;

public class QuestionBackingBean {

	private String searchExpression;
	private Question question;
	private List<Question> searchResults;
	private Choice choiceToRemove;
	
	public QuestionBackingBean() {
		resetQuestion();
	} 
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Question> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<Question> searchResults) {
		this.searchResults = searchResults;
	}

	public String getSearchExpression() {
		return searchExpression;
	}

	public void setSearchExpression(String searchExpression) {
		this.searchExpression = searchExpression;
	}
	
	public boolean isQuestionWithMoreThanOneChoice() {
		return question.getChoices().size() > 1;
	}

	public Choice getChoiceToRemove() {
		return choiceToRemove;
	}

	public void setChoiceToRemove(Choice choiceToRemove) {
		this.choiceToRemove = choiceToRemove;
	}
	
	public void resetQuestion() {
		question = new Question();
		question.addChoice( new Choice() );
	}
}

