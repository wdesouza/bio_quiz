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

import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.google.common.base.Preconditions;

import br.org.quiz.controller.core.EnumAction;
import br.org.quiz.controller.core.MessageDeliver;
import br.org.quiz.controller.core.SessionManager;
import br.org.quiz.database.entity.Player;
import br.org.quiz.database.entity.Question;
import br.org.quiz.database.entity.QuestionMapping;
import br.org.quiz.database.entity.Quiz;
import br.org.quiz.database.facade.QuizFacade;
import br.org.quiz.model.quiz.QuizFactory;

@ManagedBean
@ViewScoped
public class QuizController {

	private Quiz quiz;
	private Iterator<QuestionMapping> questionsIterator;
	private QuestionMapping actualMapping;
	private QuizFacade quizFacade;
	
	private Integer questionCount;
	private Integer acertosCount;
	private Integer errorsCount;
	
	public QuizController() {
		quiz = QuizFactory
				.buildQuizForAllDatabaseQuestions( 
						SessionManager.getLoggedPlayer() );
		questionsIterator = quiz.getQuestions().iterator();
		quizFacade = new QuizFacade();
		initCounters();
		advance();
	}
	
	private void advance() {
		actualMapping = questionsIterator.next();
	}
	
	private void initCounters() {
		questionCount = quiz.getQuestions().size();
		acertosCount = 0;
		errorsCount = 0;
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
		try {
			verifyChoiceSelection();
			verificarAcerto();
			advance();
		} catch(IllegalArgumentException e) {
			MessageDeliver.addErrorMessage("", e.getMessage());
		} 
	}

	private void verifyChoiceSelection() {
		Preconditions.checkArgument(actualMapping.getAlternativaSelecionada() != null
									, "Selecione ao menos uma alternativa!");
	}

	private void verificarAcerto() {
		if (actualMapping.isCorrect()) {
				acertosCount++;
				MessageDeliver.addSuccessMessage("Acertou!", "");
		} else {
			MessageDeliver.addErrorMessage("Você errou ...", "");
			errorsCount++;
		}
		
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	public Integer getErrorsCount() {
		return errorsCount;
	}

	public void setErrorsCount(Integer errorsCount) {
		this.errorsCount = errorsCount;
	}

	public boolean isLastQuestion() {
		return ! questionsIterator.hasNext();
	}
	
	public String finalizeQuiz() {
		quizFacade.insert(quiz);
		return "SHOW_SCORE";
	}

}
