package br.org.quiz.model.quiz;

import br.org.quiz.database.entity.Player;
import br.org.quiz.database.entity.Quiz;

public class QuizFactory {

	private static QuizBuilder builder;
	
	private QuizFactory(){}
	
	public static Quiz buildQuizForAllDatabaseQuestions(Player p) {
		builder = new AllDatabaseQuestionsBuilder();
		return builder.constructQuizForPlayer(p);
	}
}
