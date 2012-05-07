package br.org.quiz.database.facade;

import br.org.quiz.database.entity.Quiz;
import br.org.quiz.database.jpa.DAOTransactions;
import br.org.quiz.database.jpa.DAOTransactionsImp;

public class QuizFacade extends AbstractFacade<Quiz>{

	@Override
	protected DAOTransactions<Quiz> instantiateDao() {
		return new DAOTransactionsImp<Quiz>(Quiz.class);
	}
	
}
