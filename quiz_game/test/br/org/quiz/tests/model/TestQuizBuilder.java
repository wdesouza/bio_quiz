package br.org.quiz.tests.model;

import junit.framework.Assert;

import org.junit.Test;

import br.org.quiz.database.entity.Player;
import br.org.quiz.database.entity.Quiz;
import br.org.quiz.model.quiz.QuizFactory;

public class TestQuizBuilder {

	
	@Test
	public void testConstructQuiz() {
		
		Quiz quiz = QuizFactory.buildQuizForAllDatabaseQuestions( mockPlayer() );
		Assert.assertNotNull(quiz);
		System.out.println(quiz);
	}

	private Player mockPlayer() {
		
		Player player = new Player();
		return player;
	}
	
}
