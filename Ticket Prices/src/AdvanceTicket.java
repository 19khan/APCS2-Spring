
public class AdvanceTicket extends Ticket {
	private int daysToEvent;
	private double price;
	
	public AdvanceTicket (int n, int days) {
		super (n);
		this.daysToEvent = days;
		if (days >= 10){
			this.price = 30.00;
		}else{
			this.price = 40.00;
		}
	}
	
	public double getPrice(){
		if (this.daysToEvent >= 10){
			return 30.00;
		}else{
			return 40.00;
		}
	}
	
	public String toString() {
		return (super.toString() + " Price: " + this.price);
	}
}
