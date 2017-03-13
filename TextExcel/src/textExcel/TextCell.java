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
			int filler = 10 - this.text.length();
			String fillerText = "";
			for (int i = 0; i <= filler; i++){
				fillerText +=" ";
			}
			return fillerText;
		}
		
	}

	public String fullCellText() {
		return this.text;
	}

}
