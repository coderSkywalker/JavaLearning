

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.marek.Account;

public class CreateSequentialFile {
	
	private static final String LAST_MESSAGE = "Rekords was written. Thank You and Good bye :)";
	
	public static void main( String[] args ) {
		
		// otwiera clients.xml, zapisuje obiekty i zamyka plik
		try( BufferedWriter output = Files.newBufferedWriter(
				Paths.get( "C:\\Users\\michcmar\\Documents\\My Received Files\\nowyFolder\\MakeDirectoryAndFile\\clients.xml" ))) {
			
			Scanner input = new Scanner( System.in );
			
			Accounts accounts = new Accounts();
			
			System.out.printf( "%s%n%s%n?", "Wpisz nr konta, imiê, nazwisko i saldo",
										   "Wpisz wskaznik koñca danych, aby zakoñczyæ" );
			
			while ( input.hasNext() ) {
				try {
					Account rekord = new Account( input.next(), input.next(), input.next(), input.nextDouble() );
					accounts.getAccounts().add(rekord);
				}catch ( NoSuchElementException nsee ) {
					System.err.println( "Niepoprawne dane. Spróbuj ponownie." );
					input.nextLine();
				}
				
				System.out.print("? ");
			}
						
			JAXB.marshal( accounts, output );
			System.out.printf( "%n%s", LAST_MESSAGE );
			
		}catch ( IOException ioe ) {
			
			System.err.println( "B³¹d otwarcia pliku. Koñczê dzia³anie" );
			
		}
		
	}
	
	
	
	
	
	
	
	
	

}
