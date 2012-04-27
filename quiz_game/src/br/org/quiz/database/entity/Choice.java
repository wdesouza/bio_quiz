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
	
}