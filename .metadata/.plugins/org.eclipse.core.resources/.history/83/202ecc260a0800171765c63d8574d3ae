package textExcel;

public class TextCell implements Cell {
private String text;
	
	public TextCell (String txt){
		this.text = txt;
	}

	public String abbreviatedCellText() {
		if (this.text.length() > 10){
			return this.text.substring(0, 9);	
		}else{
			return this.text;
		}
		
	}

	public String fullCellText() {
		return this.text;
	}

}
