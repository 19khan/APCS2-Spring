package textExcel;

public class TextCell implements Cell {
private String text;
	
	public TextCell (String txt){
		this.text = txt;
	}

	public String abbreviatedCellText() {
		if (this.text.length() >= 10){
			return this.text.substring(0, 10);	
		}else{
			int filler = 9 - this.text.length();
			String fillerText = "";
			for (int i = 0; i <= filler; i++){
				fillerText +=" ";
			}
			return text +fillerText;
		}
		
	}

	public String fullCellText() {
		return this.text;
	}

}
