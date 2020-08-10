
public class FirstNameLastName {
	
	private String firstName;
	private String lastName;
	
	public FirstNameLastName( Basics< String, String> basics ) {
		firstName = basics.getFirstVariable();
		lastName = basics.getSecondVariable();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	

}
