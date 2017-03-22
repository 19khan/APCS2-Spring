package textExcel;

public class FormulaCell extends RealCell {

	public FormulaCell (String input) {
		super(input);
	}
	
	public String abbreviatedCellText(){
		if (this.fullCellText().length() > 10){
			return this.fullCellText().substring(0, 10);
		} else {
			String finalstr = this.fullCellText();
			while (finalstr.equals(this.fullCellText())){
				finalstr += " ";
			}
			return finalstr;
		}
	}
	
	public String fullCellText() {
		return super.fullCellText();
	}
	
	public String getType(){
		return "FormulaCell";
	}
}
