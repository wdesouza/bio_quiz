package br.org.quiz.controller;

import java.util.Iterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.org.quiz.controller.core.SessionManager;
import br.org.quiz.database.entity.Player;
import br.org.quiz.database.entity.Question;
import br.org.quiz.database.entity.QuestionMapping;
import br.org.quiz.database.entity.Quiz;
import br.org.quiz.model.quiz.QuizFactory;

@ManagedBean
@ViewScoped
public class QuizController {

	private Quiz quiz;
	private Iterator<QuestionMapping> questionsIterator;
	private QuestionMapping actualMapping;
	
	private Integer questionCount;
	private Integer acertosCount;

	public QuizController() {
		quiz = QuizFactory
				.buildQuizForAllDatabaseQuestions( 
						SessionManager.getLoggedPlayer() );
		questionsIterator = quiz.getQuestions().iterator();
		
		questionCount = new Integer(0);
		acertosCount = new Integer(0);
		
		nextQuestion();
	}
	
	
	public Integer getAcertosCount() {
		return acertosCount;
	}

	public void setAcertosCount(Integer acertosCount) {
		this.acertosCount = acertosCount;
	}

	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}

	public QuestionMapping getActualMapping() {
		return actualMapping;
	}

	public void setActualMapping(QuestionMapping questionMapping) {
		this.actualMapping = questionMapping;
	}

	public Question getActualQuestion() {
		return actualMapping.getQuestion();
	}

	public Integer getQuestionCount() {
		return questionCount;
	}

	public void nextQuestion() {
		if (actualMapping != null) {
			verificarAcerto();
		}
		
		if (questionsIterator.hasNext()) {
			actualMapping = questionsIterator.next();
			questionCount++;
		}
	}

	private void verificarAcerto() {
		if (actualMapping.isCorrect()) 
				acertosCount++;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	public boolean isLastQuestion() {
		return ! questionsIterator.hasNext();
	}
}
