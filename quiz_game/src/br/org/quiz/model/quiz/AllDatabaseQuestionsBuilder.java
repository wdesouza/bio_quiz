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
package br.org.quiz.model.quiz;

import java.util.ArrayList;
import java.util.List;

import br.org.quiz.database.entity.Player;
import br.org.quiz.database.entity.Question;
import br.org.quiz.database.entity.QuestionMapping;
import br.org.quiz.database.entity.Quiz;
import br.org.quiz.database.facade.QuestionFacade;

public class AllDatabaseQuestionsBuilder implements QuizBuilder{

	private QuestionFacade questionFacade;
	
	protected AllDatabaseQuestionsBuilder() {
		questionFacade = new QuestionFacade();
	}
	
	@Override
	public Quiz constructQuizForPlayer(Player player) {
		
		List<QuestionMapping> questions = constructMapping();
		Quiz quiz = new Quiz();
		quiz.setPlayer( player );
		quiz.setQuestions( questions );
		return quiz;
	}

	private List<QuestionMapping> constructMapping() {
		
		List<Question> allDatabaseQuestions = questionFacade.findQuestionsByDescription("");
		List<QuestionMapping> questions = new ArrayList<QuestionMapping>();
		
		for(Question question : allDatabaseQuestions) {
			QuestionMapping mapping = new QuestionMapping();
			mapping.setQuestion( question );
			questions.add( mapping );
		}
		
		return questions;
	}
}
