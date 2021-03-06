package com.marek.rozdzial.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Boot {
	
	public static void main( String[] args ) {
		PrintTask task = new PrintTask( "alibaaba" );
		task.run();
		
		PrintTask taskDrugi = new PrintTask( "dartagnian" );
		PrintTask taskTrzeci = new PrintTask( "atos" );
		PrintTask taskCzwarty = new PrintTask( "portos" );
		PrintTask taskPi�ty = new PrintTask( "aramis" );
		PrintTask taskSz�sty = new PrintTask( "richelieu" );
		
		System.out.println( "Uruchamianie wykonawcy zada�" );
		
		//Utworzenie ExecutorService do zarz�dzania zadaniami
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		//wykonaj trzy zadania PrintTask
		executorService.execute( taskDrugi );
		executorService.execute( taskTrzeci );
		executorService.execute( taskCzwarty );
		executorService.execute( taskPi�ty );
		executorService.execute( taskSz�sty );
		
		// wy��cz ExecutorService - on sam zdecyduje, kiedy wy��czy� w�tki
		executorService.shutdown();
		
		try {
			Thread.sleep( 3000 );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		
		
		System.out.printf( "Zadania uruchomione, koniec main%n%n" );
		System.out.println( "a teraz niespodzianka P.S. haha to jest dopiero koniec");
		
		
		
	}
	
	
	
}
