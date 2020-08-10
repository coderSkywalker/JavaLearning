package com.thread.one;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println( "welcome from myRunnable's implementation of run() in another thread" );
		
	}

}
