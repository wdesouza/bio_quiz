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


/**
 * The persistent class for the quiz_questao database table.
 * 
 */
@Entity
@Table(name="quiz_questao",schema="quiz")
public class QuestionMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QuestionMappingKey id;

	@Column(name="alternativa_selecionada")
	private Integer alternativaSelecionada;

	@OneToOne
	@JoinColumn(name="ref_quiz")
	private Quiz quiz;

	@ManyToOne
	@JoinColumn(name="ref_questao",insertable=false,updatable=false)
	private Question question;

    public QuestionMapping() {
    	id = new QuestionMappingKey();
    }

	public QuestionMappingKey getId() {
		return this.id;
	}

	public void setId(QuestionMappingKey id) {
		this.id = id;
	}
	
	public Integer getAlternativaSelecionada() {
		return this.alternativaSelecionada;
	}

	public void setAlternativaSelecionada(Integer alternativaSelecionada) {
		this.alternativaSelecionada = alternativaSelecionada;
		System.out.println("Selecionada " + alternativaSelecionada);
	}

	public Quiz getQuiz() {
		return this.quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
		if(question != null)
			id.setRefQuestao( question.getIdQuestao() );
	}
	
	public Integer getRefQuiz() {
		return this.id.getRefQuiz();
	}

	public void setRefQuiz(Integer refQuiz) {
		this.id.setRefQuiz(refQuiz);
	}

	public Integer getRefQuestao() {
		return this.id.getRefQuestao();
	}

	public void setRefQuestao(Integer refQuestao) {
		this.id.setRefQuestao(refQuestao);
	}
	
	public boolean isCorrect() {
		
		Integer questionAnswer = question.getAnswer().getIdAlternativa();		
		return  questionAnswer.equals(this.alternativaSelecionada);
	}
}