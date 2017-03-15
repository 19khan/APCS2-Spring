package textExcel;

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
		String [] splitCommand = command.split(" ");
		if (splitCommand.length == 1){
			if (splitCommand[0].toLowerCase().equals("clear")){		//if command is "clear"
				for (int i = 0; i < cells.length; i++){
					for (int j = 0; j < cells [i].length; j++){
						cells [i][j] = new EmptyCell();
					}
				}
			}else{		//if calling for cell inspection
				int col = splitCommand[0].toUpperCase().charAt(0) - 'A';
				int row = Integer.parseInt(splitCommand[0].substring(1));
				
				if (cells[row][col].fullCellText().equals("")){		//when inspecting an empty cell
					return "";
				}else{
					return cells [row][col].fullCellText();
				}
			}
		}if (splitCommand.length == 2){		//clearing a specific cell
			int col = splitCommand[1].toUpperCase().charAt(0) - 'A';
			int row = Integer.parseInt(splitCommand[1].substring(1));
				
			cells [row][col] = new EmptyCell();
			return getGridText();
				
		}else{		//if it has format "location" = "value"
			int col = splitCommand[0].toUpperCase().charAt(0) - 'A';
			int row = Integer.parseInt(splitCommand[0].substring(1));
				
			cells [row][col] = new TextCell(splitCommand[2]);
			return getGridText();
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
	
	public String getGridText(){
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
}