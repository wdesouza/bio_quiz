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
