package br.org.quiz.database.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jogador database table.
 * 
 */
@Entity
@Table(name="jogador",schema="quiz")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String nome;

	//bi-directional many-to-one association to Quiz
	@OneToMany(mappedBy="player")
	private List<Quiz> quizes;

    public Player() {
    }

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Quiz> getQuizes() {
		return this.quizes;
	}

	public void setQuizes(List<Quiz> quizes) {
		this.quizes = quizes;
	}
	
}