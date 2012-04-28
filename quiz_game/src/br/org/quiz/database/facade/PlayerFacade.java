package br.org.quiz.database.facade;

import br.org.quiz.database.entity.Player;
import br.org.quiz.database.jpa.DAOTransactions;
import br.org.quiz.database.jpa.DAOTransactionsImp;

public class PlayerFacade extends AbstractFacade<Player> {

	public PlayerFacade() {
	}

	@Override
	protected DAOTransactions<Player> instantiateDao() {
		return new DAOTransactionsImp<Player>(Player.class);
	}

	/**
	 * Verifica se jogador esta no banco
	 * 
	 * @param player
	 * @return verdadeiro se existe
	 */
	public Boolean playerExists(Player player) {
		return (dao.find(player.getEmail()) != null);
	}

}
