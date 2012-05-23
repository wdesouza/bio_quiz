package br.org.quiz.controller.core;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;


public class QuizPhaseListener implements PhaseListener{

	private static final long serialVersionUID = 1L;
	private static final String GAME_VIEW = "/quiz.xhtml";
	
	@Override
	public void afterPhase(PhaseEvent event) {
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	
		FacesContext context = event.getFacesContext(); 
		String viewId = context.getViewRoot().getViewId();
		
		if(! SessionManager.playerIsLogged() 
					&& viewId.equals(GAME_VIEW))
			preventUserGame(context);
	}

	private void preventUserGame(FacesContext context) {
		try {
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			context.getExternalContext().redirect(request.getContextPath());
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
