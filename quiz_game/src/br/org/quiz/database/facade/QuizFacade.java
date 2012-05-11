package br.org.quiz.database.facade;

import java.util.Collections;
import java.util.List;

import br.org.quiz.database.entity.Quiz;
import br.org.quiz.database.jpa.DAOTransactions;
import br.org.quiz.database.jpa.DAOTransactionsImp;

public class QuizFacade extends AbstractFacade<Quiz>{

	@Override
	protected DAOTransactions<Quiz> instantiateDao() {
		return new DAOTransactionsImp<Quiz>(Quiz.class);
	}
	
	public List<Quiz> retrieveGamesScoreOrdered() {
		List<Quiz> games = dao.executeNamedQuery("Quiz.search");
		Collections.sort(games, new QuizScoreComparator());
		return games;
	}
}
