/*
 * Copyright 2012 Matheus Binotto, Welliton de Souza
 *
 * Este arquivo é parte do programa BioQuiz
 *
 * BioQuiz é um software livre; você pode redistribui-lo e/ou 
 * modifica-lo dentro dos termos da Licença Pública Geral GNU como 
 * publicada pela Fundação do Software Livre (FSF); na versão 2 da 
 * Licença, ou (na sua opnião) qualquer versão.
 *
 * Este programa é distribuido na esperança que possa ser  util, 
 * mas SEM NENHUMA GARANTIA; sem uma garantia implicita de ADEQUAÇÂO a qualquer
 * MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a
 * Licença Pública Geral GNU para maiores detalhes.
 *
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package br.org.quiz.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.org.quiz.controller.core.EnumAction;
import br.org.quiz.database.entity.Player;
import br.org.quiz.database.facade.PlayerFacade;

@ManagedBean
@SessionScoped
public class PlayerController {

	private Player player;

	private PlayerFacade facade;

	
	public PlayerController() {
		player = new Player();
		facade = new PlayerFacade();
	}

	public EnumAction play() {
		try {
			boolean exists = facade.playerExists(player);
			if (!exists) {
				facade.insert(player);
			}
			return EnumAction.SUCCESS;
		} catch (Exception e) {
			return EnumAction.ERROR;
		}
	}

	public PlayerFacade getFacade() {
		return facade;
	}

	public Player getPlayer() {
		return player;
	}

	public void setFacade(PlayerFacade facade) {
		this.facade = facade;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
