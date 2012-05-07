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

	//uni-directional one-to-one association to Quiz
	@OneToOne
	@JoinColumn(name="ref_quiz")
	private Quiz quiz;

	//uni-directional one-to-one association to Question
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
	
}