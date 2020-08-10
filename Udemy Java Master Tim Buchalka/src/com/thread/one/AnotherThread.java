package com.thread.one;

public class AnotherThread extends Thread {
	
	public void run() {
		System.out.println( ThreadColor.ANSI_GREEN+"Hello from another thread" + currentThread().getName() );
		
		try {
			Thread.sleep( 3000 );
		} catch ( InterruptedException e ) {
			System.out.println( "Another thread wake me up");
			return;
		}
		
		System.out.println( " three seconds passed and I'm awake" );
	}
	

}
