package com.marek.rozdzial.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {
	
	public static void main( String[] args ) {
		
		SimpleArray sharedSimpleArray = new SimpleArray(9);
		
		ArrayWriter writer1 = new ArrayWriter( 1, sharedSimpleArray );
		ArrayWriter writer2 = new ArrayWriter( 2, sharedSimpleArray );
		ArrayWriter writer3 = new ArrayWriter( 3, sharedSimpleArray );
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute( writer1 );
		executor.execute( writer2 );
		executor.execute( writer3 );
		
		executor.shutdown();
		
		try {
			
			boolean taskEnded = executor.awaitTermination( 1, TimeUnit.MINUTES );
			if ( taskEnded ) {
				System.out.printf( "%nZawartoœæ SimpleArray:%n" );
				System.out.println( sharedSimpleArray );
			}else {
				System.out.printf( "%Up³yn¹³ czas oczekiwania na zakoñczenie zadañ%n." );
			}
			
			
		}catch ( InterruptedException ex ) {
			ex.printStackTrace();
		}
		
	}
}
