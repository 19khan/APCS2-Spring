
public class WalkupTicket extends Ticket {
	private double price = 50.00;
	
	public WalkupTicket (int n){
		super (n);
	}
	
	public double getPrice(){
		return price;
	}
	
	public String toString(){
		return (super.toString() + " Price: " + this.price);
	}
}

