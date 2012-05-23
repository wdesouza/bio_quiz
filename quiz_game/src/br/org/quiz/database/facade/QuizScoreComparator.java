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
package br.org.quiz.database.facade;

import java.util.Comparator;

import br.org.quiz.database.entity.Quiz;

public class QuizScoreComparator implements Comparator<Quiz>{

	@Override
	public int compare(Quiz quiz1, Quiz quiz2) {
		
		
		if(quiz1.getScore() > quiz2.getScore()) return -1;
		else if(quiz1.getScore() < quiz2.getScore()) return 1;
		
		if(quiz1.getTempo() < quiz2.getTempo()) return -1;
		else if(quiz1.getTempo() > quiz2.getTempo()) return 1;
		
		return 0;
	}

}
