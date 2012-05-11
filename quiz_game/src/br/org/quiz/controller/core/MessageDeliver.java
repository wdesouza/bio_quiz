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
