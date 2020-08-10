
public class Boot {

	public static void main( String[] args ) {
		Basics< String, Integer > klasa = new Basics<>( "Marcin", 23);
		Basics< String, Double > klasaNowa = new Basics<>( "Jan", 30.0 );
		
		FirstNameLastName klasaName = new FirstNameLastName( new Basics<>("Jan", "Kowalski"));
		IdAndLuckyNumber klasaNumbers = new IdAndLuckyNumber( new Basics<>( 5, 217.0));
		
		System.out.println( klasa.getFirstVariable() + " " + klasa.getSecondVariable() + " " + klasaNowa.getFirstVariable() + " " + klasaNowa.getSecondVariable());
		System.out.println( klasaName.getFirstName() + " " + klasaName.getLastName());
		System.out.println( klasaNumbers.getId() + " " + klasaNumbers.getLuckyNumber());
		
	}
	
}
