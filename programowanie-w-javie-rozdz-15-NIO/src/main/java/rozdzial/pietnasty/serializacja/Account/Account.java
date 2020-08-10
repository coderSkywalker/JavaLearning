package rozdzial.pietnasty.serializacja.Account;

public class Account {
	
	private String accountNumber;
	private String firstName;
	private String lastName;
	private double balance;
	
	public Account() {
		this("", "", "", 0.0 );
	}
	
	public Account( String accountNumber, String firstName, String lastName, double balance ) {
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber( String accountNumber ) {
		this.accountNumber = accountNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance( double balance ) {
		this.balance = balance;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
