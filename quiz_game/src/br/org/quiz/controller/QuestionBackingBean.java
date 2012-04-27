package br.org.quiz.controller;

import java.util.List;

import br.org.quiz.database.entity.Question;

public class QuestionBackingBean {

	private String searchExpression;
	private Question question;
	private List<Question> searchResults;
	
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
	
	
}

