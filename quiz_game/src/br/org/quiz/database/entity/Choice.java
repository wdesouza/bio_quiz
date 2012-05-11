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
 * The persistent class for the alternativa database table.
 * 
 */
@Entity
@Table(name="alternativa",schema="quiz")
public class Choice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize=1,name="choiceSequenceGen",sequenceName="quiz.seq_alternativa")
	@GeneratedValue(generator="choiceSequenceGen")
	@Column(name="id_alternativa")
	private Integer idAlternativa;

	private String comentario;

	private String descricao;

	private Integer verdade;

	@Column(name="ref_questao")
	private Integer refQuestao;
	
	//bi-directional many-to-one association to Question
    @ManyToOne
	@JoinColumn(name="ref_questao",insertable=false,updatable=false)
	private Question question;

    public Choice() {
    	this.verdade = 0;
    }

	public Integer getIdAlternativa() {
		return this.idAlternativa;
	}

	public void setIdAlternativa(Integer idAlternativa) {
		this.idAlternativa = idAlternativa;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getVerdade() {
		return this.verdade;
	}

	public void setVerdade(Integer verdade) {
		this.verdade = verdade;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Integer getRefQuestao() {
		return refQuestao;
	}

	public void setRefQuestao(Integer refQuestao) {
		this.refQuestao = refQuestao;
	}
	
	public boolean isValidAnswer() {
		return this.getVerdade() == 1;
	}

	@Override
	public String toString() {
		return String
				.format("Choice [idAlternativa=%s, comentario=%s, descricao=%s, verdade=%s, refQuestao=%s]\n",
						idAlternativa, comentario, descricao, verdade,
						refQuestao);
	}
	
	
}