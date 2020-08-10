package com.thread.one;

public class Boot {

	public static void main( String[] args ) {
		System.out.println( "welcome from main thread");
		
		Thread anotherThread = new AnotherThread();
		anotherThread.setName( "== Another Thread ==" );
		
		anotherThread.start();
		
		new Thread() {
			public void run() {
				System.out.println( "hello from anonymous class thread");
			}
		}.start();
		
		anotherThread.interrupt();
		
		Thread myRunnableThread = new Thread( new MyRunnable() );
		myRunnableThread.start();
		
		Thread myRunnableThreadAnonymous  = new Thread( new MyRunnable() {
			public void run() {
				System.out.println( "hello from anonymous MyRunnable" );
			}
		});
		
		new Thread( new Runnable() {

			@Override
			public void run() {
				System.out.println( "to jest dopiero kosmos anonimowy thread "
						+ "z anonimow¹ implementacj¹ runnable interface");
				
			}
			
		}).start();
		
		myRunnableThreadAnonymous.start();
		
		System.out.println( "hello again from main thread" );
		
		
	}
	
}
