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
