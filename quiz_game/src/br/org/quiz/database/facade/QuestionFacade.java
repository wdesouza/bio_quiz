package br.org.quiz.database.facade;

import com.google.common.base.Preconditions;

import br.org.quiz.database.entity.Question;
import br.org.quiz.database.jpa.DAOTransactions;
import br.org.quiz.database.jpa.DAOTransactionsImp;

public class QuestionFacade extends AbstractFacade<Question>{

	public QuestionFacade() {}
	
	@Override
	protected DAOTransactions<Question> instantiateDao() {
		return new DAOTransactionsImp<Question>(Question.class);
	}

	public Integer getQuestionMaxId() {
		return dao.getMax("idQuestao");
	}
	
	@Override
	public void insert(Question question) {
		checkQuestion(question);
		injectNextId(question);
		super.insert(question);
	}

	private void injectNextId(Question question) {
		Integer nexId = getQuestionMaxId() + 1;
		question.setIdQuestao(nexId);
	}

	private void checkQuestion(Question question) {
		Preconditions.checkState( question.hasAnswer()
								, "Não há resposta válida definida " +
								  "para a pergunta '%s'." );
	}
}
