package br.org.quiz.model.quiz;

public final class Timer {

	private long start = 0;
	private long end   = 0;
	
	private boolean terminated;
	
	public Timer(boolean start) {
		if(start)
			start();	
	}
	
	public void start() {
		start = System.currentTimeMillis();
	}
	
	public void stop() {
		end = System.currentTimeMillis();
	}
	
	public double elapsedSeconds() {
		return (end - start) / 1000.0;
	}
}
