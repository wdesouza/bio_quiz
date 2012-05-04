package br.org.quiz.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.org.quiz.controller.core.EnumAction;
import br.org.quiz.controller.core.MessageDeliver;
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
	
	public void removeChoice() {
		List<Choice> choices = backingBean.getQuestion().getChoices();
		if(choices.isEmpty() || choices.size() <= 1)
			return;
		choices.remove( choices.size() - 1);
	}
	
	public QuestionBackingBean getBackingBean() {
		return backingBean;
	}
	
	public void search() {
		List<Question> questions = facade.findQuestionsByDescription( backingBean.getSearchExpression() );
		backingBean.setSearchResults(questions);
	}
	
	public void delete() {
		try {
			facade.delete( backingBean.getQuestion() );
			search();
			MessageDeliver.addSuccessMessage();
		}catch(Exception e) {
			MessageDeliver.addErrorMessage("Não foi possível deletar a questão.");
			e.printStackTrace();
		}
	}
	
	public EnumAction insert() {
		try {
			facade.insert( backingBean.getQuestion() );
			backingBean.resetQuestion();
			MessageDeliver.addSuccessMessage();
			return EnumAction.SUCCESS;
		}catch(Exception e) {
			MessageDeliver.addErrorMessage("Não foi possível inserir a questão.");
			e.printStackTrace();
			return EnumAction.ERROR;
		}
	}
}
