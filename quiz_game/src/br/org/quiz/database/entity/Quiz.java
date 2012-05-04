package br.org.quiz.database.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the quiz database table.
 * 
 */
@Entity
@Table(name="quiz",schema="quiz")
public class Quiz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_quiz")
	private Integer idQuiz;

    @Temporal( TemporalType.DATE)
	@Column(name="data_quiz")
	private Date dataQuiz;

    @Column(name="ref_jogador")
    private String refJogador;
    
	//bi-directional many-to-one association to Player
    @ManyToOne
	@JoinColumn(name="ref_jogador",insertable=false, updatable=false)
	private Player player;

    public Quiz() {
    	this.dataQuiz = new Date();
    }

	public Integer getIdQuiz() {
		return this.idQuiz;
	}

	public void setIdQuiz(Integer idQuiz) {
		this.idQuiz = idQuiz;
	}

	public Date getDataQuiz() {
		return this.dataQuiz;
	}

	public void setDataQuiz(Date dataQuiz) {
		this.dataQuiz = dataQuiz;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getRefJogador() {
		return refJogador;
	}

	public void setRefJogador(String refJogador) {
		this.refJogador = refJogador;
	}
	
	
	
}