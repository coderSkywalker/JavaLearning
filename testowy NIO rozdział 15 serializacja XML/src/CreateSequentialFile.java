

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
			
			System.out.printf( "%s%n%s%n?", "Wpisz nr konta, imi�, nazwisko i saldo",
										   "Wpisz wskaznik ko�ca danych, aby zako�czy�" );
			
			while ( input.hasNext() ) {
				try {
					Account rekord = new Account( input.next(), input.next(), input.next(), input.nextDouble() );
					accounts.getAccounts().add(rekord);
				}catch ( NoSuchElementException nsee ) {
					System.err.println( "Niepoprawne dane. Spr�buj ponownie." );
					input.nextLine();
				}
				
				System.out.print("? ");
			}
						
			JAXB.marshal( accounts, output );
			System.out.printf( "%n%s", LAST_MESSAGE );
			
		}catch ( IOException ioe ) {
			
			System.err.println( "B��d otwarcia pliku. Ko�cz� dzia�anie" );
			
		}
		
	}
	
	
	
	
	
	
	
	
	

}
