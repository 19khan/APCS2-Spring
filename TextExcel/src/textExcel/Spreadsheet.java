package textExcel;
import java.io.*;
import java.util.*;

public class Spreadsheet implements Grid{
	
private Cell [][] cells = new Cell [this.getRows()][this.getCols()];	

	public Spreadsheet (){
		for (int i = 0; i < cells.length; i++){
			for (int j = 0; j < cells [i].length; j++){
				cells [i][j] = new EmptyCell();
			}
		}
	}

	public String processCommand(String command){
		String [] splitCommand = command.split(" ", 3);		//splits "command" by " ". After the second split, rest stay together.
		if (command.indexOf("=")>0){		//if value is set at specific location.
			String location = splitCommand[0].toUpperCase();		//to uppercase in case given location is in lowercase.
			
			String value = splitCommand[2];
			assignValue (location, value);
			
			return getGridText();
			
		}else if(splitCommand[0].equalsIgnoreCase("clear")
				&& splitCommand.length == 2){	//if "clear" is called asking for specific location..
			SpreadsheetLocation coordinate = new SpreadsheetLocation(splitCommand[1].toUpperCase());
			cells [coordinate.getRow()][coordinate.getCol()] = new EmptyCell();
			
			return getGridText();
			
		}else if (command.equalsIgnoreCase("clear")){		//if command is calling for clearing whole cell.
			for (int i = 0; i < cells.length; i++){
				for (int j = 0; j < cells[i].length; j++){
					cells [i][j] = new EmptyCell();
				}
			}
			return getGridText();
			
		}else{		//cell inspection
			return inspect(command.toUpperCase());
		}
	}

	public int getRows(){
		return 20;
	}

	public int getCols(){
		return 12;
	}

	public Cell getCell(Location loc){
		return cells[loc.getRow()][loc.getCol()];
	}
	
	public String getGridText(){		//print out entire grid.
		String finalGrid = "";
		String header = "   |";
		char start = 'A';
		for (int col = 0; col < this.getCols(); col++){		//for loop for the first row which includes the header for each column.
			header += ((char)(start + col)) + "         |";		//use unicode and cast it to char in order to get A to L
		}
		header += "\n";
		finalGrid += header;		//Add the header to "finalGrid"
		
		String rowsHeading = "";
		for (int row = 0; row < this.getRows(); row++){
			String rows = "";
			if (row < 9){		//if the row header digit is less than two digits.
				rowsHeading = ((row+1)+"  |");
			}else{		//if it exceeds one digit.
				rowsHeading = ((row+1)+" |");
			}
			finalGrid += rowsHeading;		//Add row heading to "finalGrid" before adding the actual rows.
			for (int col = 0; col < this.getCols(); col++){	
				rows += cells[row][col].abbreviatedCellText()+"|";		//use .abbreviatedCellText of the cells itself to make sure the texts fit the boxes.
			}
			rows += "\n";		//add new line at the end of each row when it reaches L column.
			finalGrid += rows;		//add everything to "finalGrid"
		}							//"finalGrid" turns into a very long string that prints out the whole spreadsheet.
		return finalGrid;		//return "finalGrid."
	}
	
	public void assignValue (String location, String value){		//assigning value to specific cell.
		SpreadsheetLocation coordinate = new SpreadsheetLocation(location);		//used to separate the letter column from number row.
		if (value.indexOf("%") > 0){
			cells[coordinate.getRow()][coordinate.getCol()] = new PercentCell(value);
		}else if (value.charAt(0) == '('
				&& value.charAt(value.length()-1) == ')'){
			cells[coordinate.getRow()][coordinate.getCol()] = new FormulaCell(value);
		}else if (value.charAt(0) == '"'
				&& value.charAt(value.length()-1) == '"'){
			cells[coordinate.getRow()][coordinate.getCol()] = new TextCell(value.substring(1, value.length()-1));		//substring from 1 to length-1 to get rid of quotations.
		}else {
			cells[coordinate.getRow()][coordinate.getCol()] = new ValueCell(value);
		}
	}
	
	public String inspect (String location){		//cell inspection.
		SpreadsheetLocation coordinate = new SpreadsheetLocation(location);		//used to separate letter column from number row.
		return cells[coordinate.getRow()][coordinate.getCol()].fullCellText();		//returns fullCellText when inspecting a celll
	}
	
	public String SaveFile (String filename) {
		PrintWriter outputFile;
		try {
			outputFile = new PrintWriter (new File(filename));
		}
		catch (FileNotFoundException e) {
			return "File not found: " + filename;
		}
		
		outputFile.close();
		return "something";
	}
	
	public String OpenFile (String filename) {
		Scanner inputFile;
		try {
			inputFile = new Scanner (new File(filename));
		}
		catch (FileNotFoundException e) {
			return "File not found: " + filename;
		}
		inputFile.close();
		return "something";
	}
}