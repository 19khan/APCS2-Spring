package textExcel;

public class FormulaCell extends RealCell {
	private String [] equation;
	
	public FormulaCell (String input) {
		super(input);
		equation = input.substring(2, input.length()-2).split(" ");
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
	
	public double solve (int position, double answer) {
		position = 0;
		answer = 0.0;
		if (position == equation.length){
			return answer;
		}else {
			if (equation [position + 1].equals("+")){
				answer = getDoubleValue(equation[position]) + getDoubleValue(equation[position + 2]);//add
			}else if (equation [position + 1].equals("-")){
				answer = getDoubleValue(equation[position]) - getDoubleValue(equation[position + 2]);//subtract
			}else if (equation [position + 1].equals("*")){
				answer = getDoubleValue(equation[position]) * getDoubleValue(equation[position + 2]);//multiply
			}else if (equation [position + 1].equals("/")){
				answer = getDoubleValue(equation[position]) / getDoubleValue(equation[position + 2]);//divide
			}
			solve (position+3, answer);
			return answer;
		}
	}
	
	public double getDoubleValue (String number) {
		return Double.parseDouble(number);
	}
	
	public String getType(){
		return "FormulaCell";
	}
}
