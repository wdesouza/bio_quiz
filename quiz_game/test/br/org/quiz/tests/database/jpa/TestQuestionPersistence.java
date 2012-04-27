package br.org.quiz.tests.database.jpa;

import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import br.org.quiz.database.entity.Choice;
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
	
	@Test
	public void testHasAnswer() {
		
		Question q = mockQuestion();
		Assert.assertTrue( q.hasAnswer() );
	}
	
	@Test
	public void testInsertQuestion() {
		
		Integer id = facade.getQuestionMaxId();
		facade.insert( mockQuestion() );
		assertThatQuestionHasBeenInserted(id);
	}

	@Test
	public void testDeleteQuestion() {
		
		Question toDelete = findSomeQuestion();
		Integer toDeleteId = toDelete.getIdQuestao();
		facade.delete(toDelete);
		Assert.assertNull(facade.find(toDeleteId));
	}
	
	private Question findSomeQuestion() {
		List<Question> allQuestions = findAllQuestions();
		Assert.assertFalse("Não há questões cadastradas.", allQuestions.isEmpty() );
		return allQuestions.get(0);
	}
	
	
	private List<Question> findAllQuestions() {
		return facade.findQuestionsByDescription("");
	}

	private void assertThatQuestionHasBeenInserted(Integer id) {
		Question question = facade.find(id + 1);
		Assert.assertNotNull(question);
		System.out.println(question);
	}

	private Question mockQuestion() {
		
		Question question = new Question();
		question.setDescricao("Qual é o sentido da vida?");
		question.addChoice( mockChoice(true, 1) );
		question.addChoice( mockChoice(false, 2) );
		question.addChoice( mockChoice(false, 3) );
		question.addChoice( mockChoice(false, 4) );
		question.addChoice( mockChoice(false, 5) );
		
		return question;
	}

	private Choice mockChoice(boolean isTrue, int sequence) {
		
		Choice c = new Choice();
		c.setVerdade(isTrue ? 1 : 0);
		c.setDescricao("Alternativa " + sequence);
		return c;
	}
	
	
}
