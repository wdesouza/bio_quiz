package br.org.quiz.tests.database.jpa;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.org.quiz.database.entity.Quiz;
import br.org.quiz.database.facade.QuizFacade;

public class TestScoreRetrieve {

	@Test
	public void testRetrieveScore() {
		
		QuizFacade quizFacade = new QuizFacade();
		List<Quiz> score = quizFacade.retrieveGamesScoreOrdered();
		
		Assert.assertFalse("Não ha quiz cadastrado.", score.isEmpty());
		for(Quiz q : score) {
			Assert.assertFalse("Não foram trazidas as questoes do quiz juntamente com ele.", q.getQuestions().isEmpty());
			System.out.println(q.getScore());
		}
	}
}
