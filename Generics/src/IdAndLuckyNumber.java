
public class IdAndLuckyNumber {
	
	private int Id;
	private double luckyNumber;
	
	public IdAndLuckyNumber( Basics< Integer, Double > numbers ) {
		Id = numbers.getFirstVariable();
		luckyNumber = numbers.getSecondVariable();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public double getLuckyNumber() {
		return luckyNumber;
	}

	public void setLuckyNumber(double luckyNumber) {
		this.luckyNumber = luckyNumber;
	}
	
	

}
