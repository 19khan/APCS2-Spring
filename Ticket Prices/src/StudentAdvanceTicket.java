
public class StudentAdvanceTicket extends AdvanceTicket {
	private boolean isStudent;
	
	public StudentAdvanceTicket (int n, int days, boolean student){
		super(n, days);
		this.isStudent = student;
	}
	
	public double getPrice() {
		if (isStudent == true){
			return (super.getPrice()) *0.5;
		}else{
			return super.getPrice();
		}
	}
	public String toString() {
		return super.toString();
	}
}
