
public class Basics< T, K > {
	
	private T firstVariable;
	private K secondVariable;
	
	public Basics( T name, K age ) {
		this.firstVariable = name;
		this.secondVariable = age;
	}
	

	public T getFirstVariable() {
		return firstVariable;
	}

	public void setFirstVariable(T name) {
		this.firstVariable = name;
	}

	public K getSecondVariable() {
		return secondVariable;
	}

	public void setSecondVariable(K age) {
		this.secondVariable = age;
	}
	
	

}
