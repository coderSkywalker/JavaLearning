package com.marek.rozdzial.concurrent;

import java.security.SecureRandom;

public class PrintTask implements Runnable {
	
	private static final SecureRandom generator = new SecureRandom();
	private final int sleepTime;
	private final String taskName;
	
	
	public PrintTask( String taskName ) {
		
		sleepTime = generator.nextInt( 5000 );
		this.taskName = taskName;
		
	}

	@Override
	public void run() {
		
		System.out.printf( "%s idzie spa� na %d milisekund%n", taskName, sleepTime );
		try {
			Thread.sleep( sleepTime );
		}catch ( InterruptedException ie ) {
			ie.printStackTrace();
			Thread.currentThread().interrupt(); // pon�w przerwanie w�tku
		}
		
		System.out.printf( "%s obudzi� si�%n", taskName );
		
	}

}
