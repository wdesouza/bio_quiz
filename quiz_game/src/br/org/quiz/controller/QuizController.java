package br.org.quiz.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.org.quiz.database.entity.Player;
import br.org.quiz.database.entity.Question;
import br.org.quiz.database.entity.QuestionMapping;
import br.org.quiz.database.entity.Quiz;
import br.org.quiz.database.facade.QuestionFacade;

@ManagedBean
@ViewScoped
public class QuizController {

	private Quiz quiz;
	private Iterator<Question> questionsIterator;
	private Question actualQuestion;
	private Integer questionCount;
	private QuestionMapping questionMapping;
	private List<QuestionMapping> questionMappings;
	private Integer acertosCount;

	public Integer getAcertosCount() {
		return acertosCount;
	}

	public void setAcertosCount(Integer acertosCount) {
		this.acertosCount = acertosCount;
	}

	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}

	public QuestionMapping getQuestionMapping() {
		return questionMapping;
	}

	public void setQuestionMapping(QuestionMapping questionMapping) {
		this.questionMapping = questionMapping;
	}

	public QuizController() {
		quiz = new Quiz();
		questionMappings = new ArrayList<QuestionMapping>();
		questionsIterator = getQuestions();
		questionCount = new Integer(0);
		acertosCount = new Integer(0);
		nextQuestion();
	}

	public Question getActualQuestion() {
		return actualQuestion;
	}

	public Integer getQuestionCount() {
		return questionCount;
	}

	private Iterator<Question> getQuestions() {
		QuestionFacade facade = new QuestionFacade();
		return facade.findQuestionsByDescription("").iterator();
	}

	public void nextQuestion() {
		if (questionMapping != null) {
			questionMappings.add(questionMapping);
			verificarAcerto();
		}
		if (questionsIterator.hasNext()) {
			actualQuestion = questionsIterator.next();
			questionMapping = new QuestionMapping();
			questionMapping.setQuestion(actualQuestion);
			questionMapping.setQuiz(quiz);
			questionCount++;
		} else {
			HttpServletRequest request = (HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();
			PlayerController attribute = (PlayerController) request
					.getSession().getAttribute("playerController");
			Player player = attribute.getPlayer();
			quiz.setPlayer(player);
		}
	}

	private void verificarAcerto() {
		Integer alternativaCorreta = actualQuestion.getAnswer()
				.getIdAlternativa();
		Integer alternativaSelecionada = questionMapping
				.getAlternativaSelecionada();
		if (alternativaSelecionada == alternativaCorreta) {
			acertosCount++;
		}
	}

	public void setActualQuestion(Question actualQuestion) {
		this.actualQuestion = actualQuestion;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

}
