package rozdzial.pietnasty.studiumprzypadku.firstcopy;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreditInquiry {
	
	private static final String ZERO_BALANCE = "Konta ze stanem zerowym";
	private static final String CREDIT_BALANCE = "Konta ze stanem ujemnym";
	private static final String DEBIT_BALANCE = "Konta ze stanem dodatnim";
	private static final String PATH_TO_FILE = "Podaj œcie¿kê do pliku";
	
	private static final MenuOption[] choices = MenuOption.values(); 
	
	public enum MenuOption {
		ZERO_BALANCE(1),
		CREDIT_BALANCE(2),
		DEBIT_BALANCE(3),
		END(4);
		
		private final int value;
		
		private MenuOption( int value ) {
			this.value = value;
		}
	}
	
	
	public static void startApp() {
		
		Scanner input = new Scanner( System.in );
		
		MenuOption accountType = getRequest( input );
		
		while ( accountType != MenuOption.END ) {
			
			switch ( accountType ) {
				case ZERO_BALANCE:
					System.out.printf( "%n%s%n", ZERO_BALANCE );
					break;
				case CREDIT_BALANCE:
					System.out.printf( "%n%s%n", CREDIT_BALANCE );
					break;
				case DEBIT_BALANCE:
					System.out.printf( "%n%s%n" , DEBIT_BALANCE );
					break;

			}
			
			readRecords( accountType );
			accountType = getRequest( input );
		}
				
	}


	private static void readRecords(MenuOption accountType) {
		
		System.out.printf("%s%n? ", PATH_TO_FILE );
		String pathToFile = new Scanner( System.in ).nextLine();
		
		try ( Scanner input = new Scanner( Paths.get(
				pathToFile ))) {
			
			while ( input.hasNext() ) {
				
				String accountNumber = input.next();
				String firstName = input.next();
				String lastName = input.next();
				double balance = input.nextDouble();
				
				if ( shouldDisplay( accountType, balance )) {
					System.out.printf( "%-30s%-12s%-16s%10.2f%n", accountNumber, firstName, lastName, balance );
				} else {
					input.nextLine();
				}
				
			}
			
			
		} catch ( NoSuchElementException | IllegalStateException | IOException nseeIseIoe ) {
			
			System.out.printf("b³¹d przetwarzania pliku. Przerywam.");
			System.exit(1);
			
		}
		
		
		
	}


	private static boolean shouldDisplay(MenuOption accountType, double balance) {
		
		if (( MenuOption.ZERO_BALANCE == accountType ) && ( balance == 0 )) return true;
		else if (( MenuOption.CREDIT_BALANCE == accountType ) && ( balance < 0)) return true;
		else if (( MenuOption.DEBIT_BALANCE == accountType ) && ( balance > 0 )) return true;
		
		return false;
	}


	private static MenuOption getRequest(Scanner input) {
		
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
	
}
