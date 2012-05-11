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