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

import javax.inject.Named;
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
@NamedQueries({
	@NamedQuery(name="Quiz.search",query="SELECT q FROM Quiz q")
})
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

    @OneToMany(mappedBy="quiz", cascade={CascadeType.PERSIST}, targetEntity=QuestionMapping.class,fetch=FetchType.EAGER)
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
		if(player != null)
			this.refJogador = player.getEmail();
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

	public int getTotalOfQuestions() {
		return this.questions.size();
	}
	
	public void setQuestions(List<QuestionMapping> questions) {
		this.questions = questions;
		for(QuestionMapping q : questions) {
			q.setQuiz( this );
		}
	}
	
	/**
	 * Retorna a quantidade de acertos de um quiz
	 * @return
	 */
	public int getScore() {
		
		int score = 0;
		for(QuestionMapping q : questions) {
			if(q.isCorrect())
				score++;
		}
		
		return score;
	}
	
}