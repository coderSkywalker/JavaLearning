package rozdzial.pietnasty.pierwszy;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {
	
	private static final String ENTER_PATH_MESSAGE = "podaj œcie¿kê do pliku z tekstem do wczytania";
	
	public static void readTextFromFile() {
		
		Scanner scanner = new Scanner( System.in );
		
		System.out.printf("%n%s%n?", ENTER_PATH_MESSAGE );
		String pathToFile = scanner.nextLine();
		
		try ( Scanner input = new Scanner( Paths.get( pathToFile ))) {
			
			System.out.printf("%-30s%-12s%-16s%10s%n", "Konto", "Imiê", "Nazwisko", "Saldo" );
			
			while ( input.hasNext() ) {
				System.out.printf("%-30s%-12s%-16s%10.2f%n",
															input.next(),
															input.next(),
															input.next(),
															input.nextDouble());
			}
			
			
		}catch ( IOException | NoSuchElementException | IllegalStateException e ) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
