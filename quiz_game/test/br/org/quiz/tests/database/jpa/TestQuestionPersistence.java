package br.org.quiz.tests.database.jpa;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.org.quiz.database.entity.Question;
import br.org.quiz.database.facade.QuestionFacade;

public class TestQuestionPersistence {

	private static QuestionFacade facade;
	
	@BeforeClass
	public static void setupClass() {
		facade = new QuestionFacade();
	}
	
	@Test
	public void testQuestionMaxId() {
		
		Integer id = facade.getQuestionMaxId();
		System.out.println(id);
	}
	
	@Ignore
	@Test
	public void testInsertQuestion() {
		
		facade.insert( mockQuestion() );
	}

	private Question mockQuestion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
