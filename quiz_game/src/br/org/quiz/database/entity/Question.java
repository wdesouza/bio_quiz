package br.org.quiz.database.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
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
	@OneToMany(mappedBy="question",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	private List<Choice> choices;

    public Question() {
    	choices = new ArrayList<Choice>();
    }

	public Integer getIdQuestao() {
		return this.idQuestao;
	}

	public void setIdQuestao(Integer idQuestao) {
		this.idQuestao = idQuestao;
		distributeIdOverChoices();
	}

	private void distributeIdOverChoices() {
		if(choices != null) {
			for(Choice c : choices) 
				c.setRefQuestao(idQuestao);
		}
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
	
	public void addChoice(Choice c) {
		this.choices.add(c);
	}
	
	public boolean hasAnswer() {
		
		if(choices == null)
			return false;
		
		for(Choice c : choices) {
			if(c.isValidAnswer())
				return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return String.format(
				"Question [idQuestao=%s, descricao=%s, \nchoices=%s]\n", idQuestao,
				descricao, choices);
	}
	
	
}