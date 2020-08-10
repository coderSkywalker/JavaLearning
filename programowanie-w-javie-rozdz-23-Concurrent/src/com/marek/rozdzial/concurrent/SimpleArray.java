package com.marek.rozdzial.concurrent;

import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleArray {
	
	private static final SecureRandom generator = new SecureRandom();
	private final int[] array;
	private int writeIndex;

	
	public SimpleArray() {
		array = new int[ 3 ];
	}
	
	public SimpleArray( int size ) {
		array = new int[ size ];
	}
	
	public synchronized void add( int value ) {
		
		int position = writeIndex;
		
		try {
			Thread.sleep( 1000 );
		}catch ( InterruptedException e ) {
			Thread.currentThread().interrupt();
		}
		
		array[ position ] = value;
		
		System.out.printf( "%s zapisa� %d na pozycji %d%n", Thread.currentThread().getName(), value, position );
		
		++writeIndex;
		
		System.out.printf( "Nast�pny index zapisu: %d%n", writeIndex );
		
	}
	
	public String toString() {
		return Arrays.toString( array );
		
	}
	
	
	
	

}
