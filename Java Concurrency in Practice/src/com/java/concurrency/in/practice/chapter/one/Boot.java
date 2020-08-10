package com.java.concurrency.in.practice.chapter.one;

public class Boot {
	
	public static void main( String[] args ) {
		
		ThreadSafeClass classOne = new ThreadSafeClass();
		
		new Thread() {
			public void run() {
				
				classOne.serviceSelf();
				classOne.serviceSelfNotAtomic();
				System.out.println( "thread 1 atomic: " + classOne.getCouterValue() );
				System.out.println( "thread 1 non atomic: " + classOne.getCounterNotAtomicValue() );
			}
		}.start();
		
		new Thread() {
			public void run() {
				
				classOne.serviceSelf();
				classOne.serviceSelfNotAtomic();
				System.out.println( "thread 2 atomic: " + classOne.getCouterValue() );
				System.out.println( "thread 2 non atomic: " + classOne.getCounterNotAtomicValue() );
			}
		}.start();
		
		new Thread() {
			public void run() {
				classOne.serviceSelf();
				classOne.serviceSelfNotAtomic();
				System.out.println( "thread 3 atomic: " + classOne.getCouterValue() );
				System.out.println( "thread 3 non atomic: " + classOne.getCounterNotAtomicValue() );
			}
		}.start();
		
		new Thread() {
			public void run() {
				classOne.serviceSelf();
				classOne.serviceSelfNotAtomic();
				System.out.println( "thread 4 atomic: " + classOne.getCouterValue() );
				System.out.println( "thread 4 non atomic: " + classOne.getCounterNotAtomicValue() );
			}
		}.start();
		
		
	}

}
