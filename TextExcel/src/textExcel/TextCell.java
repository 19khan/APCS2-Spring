package textExcel;

public class TextCell implements Cell {
private String text;
	
	public TextCell (String txt){
		this.text = txt;
	}

	public String abbreviatedCellText() {
		String finalText = "";
		finalText = this.text;
		if (this.text.length() < 10){
			while (finalText.length() < 10){
				finalText += " ";
			}
			return finalText;
		}else{
			finalText = finalText.substring(0, 10);
			return finalText;
		}
		
		
	}

	public String fullCellText() {
		return "\""+this.text+"\"";
	}

}
