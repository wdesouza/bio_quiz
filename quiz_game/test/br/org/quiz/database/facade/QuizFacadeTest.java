package br.org.quiz.database.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import br.org.quiz.database.entity.Player;
import br.org.quiz.database.entity.Question;
import br.org.quiz.database.entity.QuestionMapping;
import br.org.quiz.database.entity.Quiz;

public class QuizFacadeTest {

	private static final String PLAYER_MAIL = "matheusbinotto@hotmail.com";
	private static QuizFacade facade;
	
	@BeforeClass 
	public static void setupTest() {
		facade = new QuizFacade();
		insertMockPlayer();
	}
	
	
	@Test
	public void testInsertQuiz() {
		
		Quiz quiz = mockQuiz();
		facade.insert(quiz);
		
	}

	private Quiz mockQuiz() {
		
		Quiz quiz = new Quiz();
		quiz.setDataQuiz( new Date() );
		quiz.setRefJogador(PLAYER_MAIL);
		quiz.setQuestions( provideQuestions() );
		
		return quiz;
	}
	

	private List<QuestionMapping> provideQuestions() {
		
		List<QuestionMapping> mappings = new ArrayList<QuestionMapping>();
		for(Question q : provideQuestionsOfDatabase()) {
			
			QuestionMapping map = new QuestionMapping();
			map.setRefQuestao( q.getIdQuestao() );
			map.setAlternativaSelecionada( q.getAnswer().getIdAlternativa() );
			mappings.add(map);
		}
		
		return mappings;
	}


	private List<Question> provideQuestionsOfDatabase() {
		QuestionFacade questionFacade = new QuestionFacade();
		List<Question> questions = questionFacade.findQuestionsByDescription("");
		Assert.assertFalse("Não há questões cadastradas na base de dados.",questions.isEmpty());
		return questions;
	}

	private static void insertMockPlayer() {
		
		Player player = new Player();
		player.setEmail(PLAYER_MAIL);
		player.setNome("Matheus Binotto");
		
		PlayerFacade facade = new PlayerFacade();
		if(! facade.playerExists(player))
				facade.insert(player);
	}
}
