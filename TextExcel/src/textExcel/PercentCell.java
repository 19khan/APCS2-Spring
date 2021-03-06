package textExcel;

public class PercentCell extends RealCell {
	
	public PercentCell (String input){
		super (input);
	}
	
	public String abbreviatedCellText() {
		String abbreviated = (int) getDoubleValue() + "%";
		if (abbreviated.length() < 10){
			while (abbreviated.length() < 10){
				abbreviated += " ";
			}
			return abbreviated;
		} else if (abbreviated.length() > 10){
			abbreviated = abbreviated.substring(0, 10);
			return abbreviated;
		} else {
			return abbreviated;
		}
	}
	
	public String fullCellText() {
		return (getDoubleValue()/100.0) + "";
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(super.fullCellText().substring(0, super.fullCellText().length()-1));
	}
	
}
