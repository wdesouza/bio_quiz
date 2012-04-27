package br.org.quiz.database.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the questao database table.
 * 
 */
@Entity
@Table(name="questao",schema="quiz")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_questao")
	private Integer idQuestao;

	private String descricao;

	//bi-directional many-to-one association to Choice
	@OneToMany(mappedBy="question",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Choice> choices;

    public Question() {
    }

	public Integer getIdQuestao() {
		return this.idQuestao;
	}

	public void setIdQuestao(Integer idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Choice> getChoices() {
		return this.choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}
	
}