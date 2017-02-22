
public class TicketTester {
	public static void main (String args[]) {
		WalkupTicket t1 = new WalkupTicket (5);
		System.out.println (t1.toString());
		System.out.println (t1.getPrice());
		System.out.println ();
	
		AdvanceTicket t2 = new AdvanceTicket (3, 15);
		System.out.println (t2.toString());
		System.out.println (t2.getPrice());
		System.out.println ();
		
		StudentAdvanceTicket t3 = new StudentAdvanceTicket (12, 14, true);
		System.out.println (t3.toString());
		System.out.println (t3.getPrice());
		System.out.println ();
		
		StudentAdvanceTicket t4 = new StudentAdvanceTicket (14, 5, false);
		System.out.println (t4.toString());
		System.out.println (t4.getPrice());
	}
}