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

	@Column(name="ref_quiz")
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