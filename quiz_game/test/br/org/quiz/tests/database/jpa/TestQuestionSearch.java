package br.org.quiz.tests.database.jpa;

import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import br.org.quiz.database.entity.Question;
import br.org.quiz.database.facade.QuestionFacade;

public class TestQuestionSearch {

	private static QuestionFacade facade;
	
	@BeforeClass
	public static void setupclass() {
		facade = new QuestionFacade();
	}
	
	@Test
	public void testQuestionSearch() {
		
		String expression = "seNt";
		List<Question> questions = facade.findQuestionsByDescription(expression);
		Assert.assertNotNull(questions);
		Assert.assertFalse("Não há questões cadastradas com a expressão.",questions.isEmpty());
		System.out.println(questions);
	}
	
}
