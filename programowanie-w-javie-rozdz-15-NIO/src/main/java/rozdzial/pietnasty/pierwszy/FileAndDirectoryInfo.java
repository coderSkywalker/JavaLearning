package rozdzial.pietnasty.pierwszy;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileAndDirectoryInfo {
	
	/**
	 * Java radzi sobie z dowolnym separatorem �cie�ki dost�pu ( "/" lub "\" )
	 * Gdy budujemy litera�, nale�y u�y� File.separator, kt�ry pobiera separator
	 * dla danego systemu operacyjnego.
	 */
	private static final String SEPARATOR = File.separator;

	public static void getFileAndDirectoryInfo() throws IOException {
		
		Scanner scaner = new Scanner( System.in );
		
		System.out.println("Podaj nazw� pliku lub folderu:");
		
		// Utw�rz obiekt Path na podstawie informacji od u�ytkownika
		Path path = Paths.get( scaner.nextLine() );
		
		if ( Files.exists(path)) { // Je�li �cie�ka istnieje, wy�wietla informacje o niej
			
			//Sprawdza czy jak nazywa si� ostatni element �cie�ki
			System.out.printf("%n%s istnieje%n", path.getFileName());
			// Sprawdza czy ostatni element �cie�ki jest folderem 
			System.out.printf("%s folderem%n", 
					Files.isDirectory(path) ? "Jest" : "Nie jest");
			System.out.printf("%s �cie�k� bezwzgl�dn�%n",
					path.isAbsolute() ? "Jest" : "Nie jest");
			System.out.printf("Ostatnia modyfikacja: %s%n",
					Files.getLastModifiedTime(path));
			System.out.printf("Rozmiar pliku: %s%n", Files.size(path) );
			System.out.printf("�cie�ka: %s%n", path );
			System.out.printf("�cie�ka bezwzgl�dna: %s%n", path.toAbsolutePath());
			
			// ten blok wy�wietla zawarto�� folderu
			if ( Files.isDirectory(path) ) {
//				
//				System.out.printf("%nZawarto�� folderu:%n");
//				
//				
//				DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
//				
//				for ( Path p : directoryStream ) {
//					System.out.println(p);
//				}
			
				displayContentDirectory(path);
				
			}else {
				System.out.printf("%nNie da si� wy�wietli� zawarto�ci folderu w podanej �cie�ce dost�pu");
				System.out.printf("%n%s jest plikiem a nie katalogiem", path.getFileName());
			}
			
			
		}else {
			System.out.printf("%nPodana �cie�ka jest b��dna. Nie istnieje katalog ani plik o podanej nazwie" );
		}
				
	}
	
	
	private static void displayContentDirectory( Path path ) throws IOException {
		
		if ( Files.isDirectory(path)) {
			System.out.printf( "%nZawarto�� folderu:%n" );
		
		
			DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
		
			for ( Path p : directoryStream ) {
				
				if ( Files.isDirectory(p) ) displayContentDirectory( p );
				
				System.out.println(p);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}