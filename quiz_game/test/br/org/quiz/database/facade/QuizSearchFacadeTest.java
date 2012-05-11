package br.org.quiz.database.facade;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.org.quiz.database.entity.Quiz;

public class QuizSearchFacadeTest {

	@Test
	public void testSearchGamesScoreOrdered() {
		
		QuizFacade facade = new QuizFacade();
		List<Quiz> games = facade.retrieveGamesScoreOrdered();
		Assert.assertNotNull(games);
		Assert.assertFalse(games.isEmpty());
		System.out.println(games);
	}
}
