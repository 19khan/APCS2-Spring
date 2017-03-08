package textExcel;

public class Spreadsheet implements Grid{
	
private Cell [][] cells = new Cell [this.getRows()][this.getCols()];	
	public Spreadsheet (){
		for (int i = 0; i < this.cells.length; i++){
			for (int j = 0; j < this.cells [i].length; j++){
				this.cells [i][j] = new EmptyCell();
			}
		}
	}

	public String processCommand(String command){
		String [] splitCommand = command.split(" ");
		if (splitCommand.length == 0){
			//Clear entire sheet.
			if (splitCommand [0].toLowerCase().equals("clear")){
				//do clear stuff
			}
		}if (splitCommand.length == 2){
			//Clear specific sheet
			String location = splitCommand[1];
			
			int column = location.charAt(0) - 'A';
			int row = Integer.parseInt(location.substring(1));
			
		}if (splitCommand.length == 3){
			//Assigning new value to specific location.
			String location = splitCommand[0];
		
			int column = location.charAt(0) - 'A';
			int row = Integer.parseInt(location.substring(1));
		}
		
		return command;
	}

	public int getRows(){
		return 20;
	}

	public int getCols(){
		return 12;
	}

	public Cell getCell(Location loc){
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getGridText(){
		String header = "   |";
		char start = 'A';
		for (int col = 0; col < 12; col++){
			header += ((char)(start + col)) + "         |";
		}	
		System.out.println(header);
		
		String rowsHeading = "";
		String rows = "";
		for (int row = 0; row < 20; row++){
			if (row < 10){
				rowsHeading = ((row+1)+"  |");
			}else{
				rowsHeading = ((row+1)+" |");
			for (int col = 0; col < 12; col++){	
				}
				rows += cells[row][col].abbreviatedCellText()+"|";
			}
		}
		System.out.println (rowsHeading + rows);
		return null;
	}
}