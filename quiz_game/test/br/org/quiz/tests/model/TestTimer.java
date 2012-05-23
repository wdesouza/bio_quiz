package br.org.quiz.tests.model;

import org.junit.Test;

import br.org.quiz.model.quiz.Timer;

public class TestTimer {

	
	@Test
	public void testTimer() throws InterruptedException {
		
		Timer t = new Timer(true);
		Thread.sleep( 5000 );
		t.stop();
		
		
		System.out.println("Segundos: " + t.elapsedSeconds());
	}
	
	
}
