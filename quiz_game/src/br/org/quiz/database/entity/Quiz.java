package br.org.quiz.database.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the quiz database table.
 * 
 */
@Entity
@Table(name="quiz",schema="quiz")
public class Quiz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize=1,name="quizSequenceGen",sequenceName="quiz.seq_quiz")
	@GeneratedValue(generator="quizSequenceGen")
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

    @OneToMany(mappedBy="quiz", cascade={CascadeType.PERSIST}, targetEntity=QuestionMapping.class)
    private List<QuestionMapping> questions;
    
    public Quiz() {
    	this.dataQuiz = new Date();
    	this.questions = new ArrayList<QuestionMapping>();
    }

	public Integer getIdQuiz() {
		return this.idQuiz;
	}

	public void setIdQuiz(Integer idQuiz) {
		this.idQuiz = idQuiz;
		//distributeIdOverMappings();
	}

	private void distributeIdOverMappings() {
		
		if(questions != null) {
			for(QuestionMapping mapping : questions) {
				mapping.setRefQuiz(idQuiz);
			}
		}
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

	public List<QuestionMapping> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionMapping> questions) {
		this.questions = questions;
		for(QuestionMapping q : questions) {
			q.setQuiz( this );
		}
	}
	
	
	
}