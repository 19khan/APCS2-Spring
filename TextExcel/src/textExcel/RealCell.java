package textExcel;

public class RealCell implements Cell {

	private String value;
	
	public RealCell (String command){
		this.value = command;
	}
	
	public String abbreviatedCellText() {
		String abbreviated = getDoubleValue() + "";
		
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
		return value;
	}
	
	public double getDoubleValue(){
		return Double.parseDouble(value);
	}

}
