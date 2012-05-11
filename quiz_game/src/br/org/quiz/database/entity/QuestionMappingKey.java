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
 * The primary key class for the quiz_questao database table.
 * 
 */
@Embeddable
public class QuestionMappingKey implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ref_quiz",insertable=false,updatable=false)
	private Integer refQuiz;

	@Column(name="ref_questao")
	private Integer refQuestao;

    public QuestionMappingKey() {
    }
	public Integer getRefQuiz() {
		return this.refQuiz;
	}
	public void setRefQuiz(Integer refQuiz) {
		this.refQuiz = refQuiz;
	}
	public Integer getRefQuestao() {
		return this.refQuestao;
	}
	public void setRefQuestao(Integer refQuestao) {
		this.refQuestao = refQuestao;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof QuestionMappingKey)) {
			return false;
		}
		QuestionMappingKey castOther = (QuestionMappingKey)other;
		return 
			this.refQuiz.equals(castOther.refQuiz)
			&& this.refQuestao.equals(castOther.refQuestao);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.refQuiz.hashCode();
		hash = hash * prime + this.refQuestao.hashCode();
		
		return hash;
    }
}