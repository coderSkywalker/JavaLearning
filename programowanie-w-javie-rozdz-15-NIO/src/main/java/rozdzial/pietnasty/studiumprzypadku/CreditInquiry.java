package rozdzial.pietnasty.studiumprzypadku;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreditInquiry {
	
	public enum MenuOption {
		ZERO_BALANCE(1),
		CREDIT_BALANCE(2),
		DEBIT_BALANCE(3),
		END(4);
		
		private final int value; // Aktualna opcja z menu
		
		private MenuOption( int value ) { this.value = value; }
	}
	
	private final static MenuOption[] choices = MenuOption.values();
	private static Scanner inputPath = new Scanner( System.in );
	
	private static final String PATH_TO_FILE = "Podaj œcie¿kê do pliku";
	private static final String PATH_TO_FILE_CLOSE = "Zamykam Scanner pathToFile - nie bêdzie ju¿ wiêcej potrzebny";
	
	public static void start() {
		
		Scanner input = new Scanner( System.in );
		// pobierz ¿¹danie u¿ytkownika ( np. saldo dodatnie, zerowe lub ujemne )
		MenuOption accountType = getRequest( input );
		
		while ( accountType != MenuOption.END ) {
			switch ( accountType ) {
			case ZERO_BALANCE:
				System.out.printf( "%nKonta z saldem zerowym%n" );
				break;
			case CREDIT_BALANCE:
				System.out.printf( "%nKonta z saldem ujemnym%n" );
				break;
			case DEBIT_BALANCE:
				System.out.printf( "%nKonta z saldem dodatnim%n" );
			}
			
			readRecords( accountType );
			accountType = getRequest( input );
			
		}
		System.out.printf( "%n%s", PATH_TO_FILE_CLOSE );
		inputPath.close();
		
	}
	
	// pobiera ¿¹danie od u¿ytkownika
	private static MenuOption getRequest( Scanner input ) {
		
		int request = 4;
		
		System.out.printf("%nWpisz ¿¹danie%n%s%n%s%n%s%n%s", "1. Lista kont o saldzie zerowym",
															 "2. Lista kont o saldzie ujemnym",
															 "3. Lista kont o saldzie dodatnim",
															 "4. Przerwij program");
		
		try {
			
			do {
				System.out.printf("%n? ");
				request = input.nextInt();
			}while (( request < 1 ) || ( request > 4 ));	
			
		} catch ( NoSuchElementException nsee ) {
			
			System.err.println("Niepoprawne dane. Przerywam program");
			
		}
		
		return choices[ request - 1 ];
	}
	
	private static void readRecords( MenuOption accountType ) {
		
//		System.out.printf("wprowadz œcie¿kê do pliku:%n? " );
		String path = "";
		System.out.printf("%s%n? ", PATH_TO_FILE );
		path = inputPath.nextLine();
		
		// otwórz plik i przetwórz zawartoœæ
		try ( Scanner inputTry = new Scanner( Paths.get( path.toString() ))) {
			
			while ( inputTry.hasNext() ) {
				String accountNumber = inputTry.next();
				String firstName = inputTry.next();
				String lastName = inputTry.next();
				double balance = inputTry.nextDouble();
				
				// jeœli idpowiednie saldo wyœwietl rekord
				if ( shouldDisplay( accountType, balance ) ) {
					System.out.printf( "%-30s%-16s%-12s%10.2f%n", accountNumber,
																	firstName,
																	lastName,
																	balance);
				}else {
					inputTry.nextLine(); // pomiñ pozosta³¹ czêœæ rekordu
				}
				
			}
			
		} catch ( NoSuchElementException | IllegalStateException | IOException e) {
			System.err.println("B³¹d przetwa¿ania pliku. Przerywam wykonywanie programu. Good bye :)");
			System.exit(1);
		}
		
		
	}
	
	private static boolean shouldDisplay( MenuOption option, double balance ) {
		
		if ( option == MenuOption.CREDIT_BALANCE && balance < 0 ) return true;
		else if ( option == MenuOption.DEBIT_BALANCE && balance > 0 ) return true;
		else if ( option == MenuOption.ZERO_BALANCE && balance == 0 ) return true;
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	

}
