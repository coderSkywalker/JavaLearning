package rozdzial.pietnasty.pierwszy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
	
	public static void createTextFile() {
		
		Scanner scanner = new Scanner( System.in );
		System.out.printf( "%nPodaj lokalizacjê pliku%n");
		String path = scanner.nextLine();
		
		Date date = new Date();
		
		//zastêpuje wszystkie spacje i dwukropki w obiekcie date.toString() na znaki podkreœlenia
		String dateString = date.toString().replaceAll("[ :]", "_");
		
		
		
		System.out.println( dateString );
		StringBuilder builder = new StringBuilder();
		builder.append( path);
		builder.append("\\\\");
		builder.append("CreateTextFile");
		builder.append("\\\\");
		
		path = builder.toString();

		
		Path pathNew = Paths.get( path );
		
		if ( ! Files.exists(pathNew)) {
			try {
				Files.createDirectory( pathNew );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		builder.append("\\\\");
		builder.append("nowyjes");
		builder.append("\\\\");
		builder.append("nowyjese");
		
		path = builder.toString();
		
		pathNew = Paths.get( path );
		try {
			Files.createDirectories( pathNew );
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		builder.append("\\\\");
		builder.append( dateString );
		builder.append(".txt");
		path = builder.toString();
		
		try ( Formatter output = new Formatter( path.toString() )) {
			
			System.out.printf("%s%n%s%n?", "Wpisz nr konta, imiê, nazwisko, saldo",
					"Wpisz wska¿nik koñca danych, aby zakoñczyæ.");
			
			while ( scanner.hasNext() ) {
				try {
					output.format("%s %s %s %.2f%n", scanner.next(), scanner.next(),
							scanner.next(), scanner.nextDouble() );
					
				} catch ( NoSuchElementException elementException ) {
					System.err.println("Niepoprawne dane. Spróbuj ponownie.");
					scanner.nextLine();
					
				}
				
				System.out.print("? ");
			}
			
			
			
		} catch ( SecurityException |
				FileNotFoundException |
				FormatterClosedException e ) {
			e.printStackTrace();
		}
		
	}

}
