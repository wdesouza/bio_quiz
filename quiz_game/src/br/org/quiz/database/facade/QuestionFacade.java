package br.org.quiz.database.facade;

import br.org.quiz.database.entity.Question;
import br.org.quiz.database.jpa.DAOTransactions;
import br.org.quiz.database.jpa.DAOTransactionsImp;

public class QuestionFacade extends AbstractFacade<Question>{

	public QuestionFacade() {}
	
	@Override
	protected DAOTransactions<Question> instantiateDao() {
		return new DAOTransactionsImp<Question>(Question.class);
	}
	
	
}
