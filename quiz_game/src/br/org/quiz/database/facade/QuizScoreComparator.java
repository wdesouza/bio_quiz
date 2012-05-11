package br.org.quiz.database.facade;

import java.util.Comparator;

import br.org.quiz.database.entity.Quiz;

public class QuizScoreComparator implements Comparator<Quiz>{

	@Override
	public int compare(Quiz quiz1, Quiz quiz2) {
		if(quiz1.getScore() < quiz2.getScore()) return -1;
		else if(quiz1.getScore() > quiz2.getScore()) return 1;
		return 0;
	}

}
