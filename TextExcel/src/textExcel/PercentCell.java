package textExcel;

public class PercentCell extends RealCell {

	public PercentCell (String input){
		super (input);
	}
	
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}
	
	public String fullCellText() {
		return super.abbreviatedCellText()
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(this.fullCellText().substring(0, this.fullCellText().length()-1));
	}
	
}
