
abstract public class Ticket {
	private int number;
	public Ticket (int n){
		this.number = n;
	}
	
	abstract public double getPrice();
	
	public String toString(){
		return ("Number: " + this.number);
	}
	
}