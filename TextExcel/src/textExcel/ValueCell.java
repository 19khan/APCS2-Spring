package textExcel;

public class ValueCell extends RealCell {

	private double value;
	
	public ValueCell (String input){
		super (input);
		value = Double.parseDouble(super.fullCellText());
	}
	
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}
	
	public String fullCellText() {
		return super.fullCellText();
	}
}
