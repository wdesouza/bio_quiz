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

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageDeliver {

	
	public static void addSuccessMessage() {
		
		FacesMessage message = new FacesMessage();
		message.setDetail("Operação realizada com sucesso.");
		message.setSummary("OK! ");
		message.setSeverity( FacesMessage.SEVERITY_INFO );
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static void addSuccessMessage(String sumary, String detail) {
		
		FacesMessage message = new FacesMessage();
		message.setDetail(detail);
		message.setSummary(sumary);
		message.setSeverity( FacesMessage.SEVERITY_INFO );
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public static void addErrorMessage(String sumary, String error) {
		
		FacesMessage message = new FacesMessage();
		message.setDetail(error);
		message.setSummary(sumary);
		message.setSeverity( FacesMessage.SEVERITY_ERROR );
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public static void addErrorMessage(String error) {
		
		FacesMessage message = new FacesMessage();
		message.setDetail(error);
		message.setSummary("Erro. ");
		message.setSeverity( FacesMessage.SEVERITY_ERROR );
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
}
