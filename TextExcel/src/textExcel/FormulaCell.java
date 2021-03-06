package textExcel;

public class FormulaCell extends RealCell {
	private String formula;
	
	public FormulaCell (String input) {
		super(input);
		formula = input;
	}
	
	public String abbreviatedCellText(){
		return getDoubleValue(formula)+"                      ".substring(0,10);
	}
	
	public String fullCellText() {
		return super.fullCellText();
	}
	
	public double getDoubleValue (String number) {
		String[] formulaSplit = formula.split(" ");
		double answer = Double.parseDouble(formulaSplit[1]);
		for (int i = 2; i < formulaSplit.length-1;i+=2){
			double num = Double.parseDouble(formulaSplit[i+1]);
			if (formulaSplit[i].equals("+")){
				answer+=num;
			}else if (formulaSplit[i].equals("-")){
				answer-=num;
			}else if (formulaSplit[i].equals("/")){
				answer/=num;
			}else if (formulaSplit[i].equals("*")){
				answer*=num;
			}
		}
		return answer;
	}
	
	public String getType(){
		return "FormulaCell";
	}
}
