package br.org.quiz.model.quiz;

import br.org.quiz.database.entity.Player;
import br.org.quiz.database.entity.Quiz;

public interface QuizBuilder {

	public Quiz constructQuizForPlayer(Player player);
	
}
