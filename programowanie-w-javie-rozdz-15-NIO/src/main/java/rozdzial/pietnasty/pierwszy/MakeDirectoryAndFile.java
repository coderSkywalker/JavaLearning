package rozdzial.pietnasty.pierwszy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MakeDirectoryAndFile {
	
	public static String makeDirAndFile() {
		
		StringBuilder builder = new StringBuilder();
		
		Scanner scanner = new Scanner( System.in );
		
		Date whatTimeIsItNow = new Date();
		String nameForFile = whatTimeIsItNow.toString().replaceAll("[ :]", "_");
		
		
		
		System.out.printf( "podaj œcie¿kê do zapisu pliku" );
		String pathString = scanner.nextLine();
		
		Path pathInput = Paths.get( pathString );
		
		if ( ! Files.exists( pathInput )) {
			try {
				Files.createDirectories( pathInput );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		builder.append( pathString );
		builder.append( "\\\\" );
		builder.append("MakeDirectoryAndFile");
		
		pathString = builder.toString();
		pathInput = Paths.get( pathString );
		if ( ! Files.exists( pathInput )) {
			try {
				Files.createDirectory( pathInput );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		builder.append( "\\\\" );
		builder.append( nameForFile );
		pathString = builder.toString();
		
		try ( Formatter formatter = new Formatter( pathString )) {
			
			System.out.printf("%n%s%n%s%n?", "wpisz nr konta, imiê, nazwisko, stan konta",
					"wpisz znak koñca danych aby zakoñczyæ" );
			
			while ( scanner.hasNext() ) {
				try {
					formatter.format("%s %s %s %.2f%n", scanner.next(),
							scanner.next(),
							scanner.next(),
							scanner.nextDouble() );
				}catch ( NoSuchElementException nsee ) {
					System.err.printf("%n%s%n%s", "niepoprawne dane", "spróbuj ponownie");
					scanner.nextLine();
				}
				
				System.out.print("?");
				
			}
			
		}catch ( SecurityException | FileNotFoundException | FormatterClosedException e ) {
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}

}
