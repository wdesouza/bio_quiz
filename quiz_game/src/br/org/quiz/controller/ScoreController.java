package br.org.quiz.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.org.quiz.controller.core.SessionManager;
import br.org.quiz.database.entity.Player;
import br.org.quiz.database.entity.Quiz;
import br.org.quiz.database.facade.QuizFacade;


@ManagedBean
@ViewScoped
public class ScoreController {

	private QuizFacade facade;
	private List<Quiz> fullScore;
	private String sessionMail;
	
	public ScoreController() {
		facade = new QuizFacade();
		fullScore = facade.retrieveGamesScoreOrdered();
		
		Player p = SessionManager.getLoggedPlayer();
		if(p != null)
			sessionMail = p.getEmail();
	}

	public List<Quiz> getFullScore() {
		return fullScore;
	}

	public void setFullScore(List<Quiz> fullScore) {
		this.fullScore = fullScore;
	}

	public String getSessionMail() {
		return sessionMail;
	}

	public void setSessionMail(String sessionMail) {
		this.sessionMail = sessionMail;
	}
}
