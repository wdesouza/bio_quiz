package br.org.quiz.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.org.quiz.database.entity.Choice;
import br.org.quiz.database.entity.Question;
import br.org.quiz.database.facade.QuestionFacade;

@ViewScoped
@ManagedBean
public class QuestionController {
	
	private QuestionBackingBean backingBean;
	private QuestionFacade facade;
	
	public QuestionController() {
		backingBean = new QuestionBackingBean();
		facade = new QuestionFacade();
	}
	
	public void addChoice() {
		backingBean.getQuestion().addChoice( new Choice() );
	}
	
	public QuestionBackingBean getBackingBean() {
		return backingBean;
	}
	
	public void search() {
		List<Question> questions = facade.findQuestionsByDescription( backingBean.getSearchExpression() );
		backingBean.setSearchResults(questions);
	}
	
	public void delete() {
		facade.delete( backingBean.getQuestion() );
		search();
	}
	
	
}
