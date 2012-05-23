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
package br.org.quiz.controller.core;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.org.quiz.controller.PlayerController;
import br.org.quiz.database.entity.Player;

public class SessionManager {

	public static Player getLoggedPlayer() {
		
		return getSessionPlayerController().getPlayer();
	}
	
	
	private static PlayerController getSessionPlayerController() {
		PlayerController controller;
		controller = (PlayerController) currentRequest()
											.getSession()
											.getAttribute("playerController");
		return controller;
	}
	
	public static boolean playerIsLogged() {
		
		PlayerController controller = getSessionPlayerController();
		if(controller == null) 
				return false;
		return controller.getPlayer().getEmail() != null;
	}
	
	private static HttpServletRequest currentRequest() {
		return (HttpServletRequest) FacesContext
										.getCurrentInstance()
										.getExternalContext()
										.getRequest();
	}
} 
