package br.org.quiz.controller.core;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.org.quiz.controller.PlayerController;
import br.org.quiz.database.entity.Player;

public class SessionManager {

	public static Player getLoggedPlayer() {
		
		PlayerController controller;
		controller = (PlayerController) currentRequest()
											.getSession()
											.getAttribute("playerController");
		return controller.getPlayer();
	}
	
	private static HttpServletRequest currentRequest() {
		return (HttpServletRequest) FacesContext
										.getCurrentInstance()
										.getExternalContext()
										.getRequest();
	}
} 
