package textExcel;

public class Spreadsheet implements Grid{
	
	public Spreadsheet (){
		Cell [][] cells = new Cell [getRows()][getCols()];
		for (int i = 0; i < cells.length; i++){
			for (int j = 0; j < cells [i].length; j++){
				cells [i][j] = new EmptyCell();
			}
		}
	}

	public String processCommand(String command){
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
		
		int [] rowHeading = new int [getRows()];
		for (int i = 0; i < rowHeading.length; i++){
			rowHeading[i] = i+1;
		}
		
		for (int row = 0; row < getRows()+1; row++){
			for (int j = 0; j < getCols(); j++){
				if (j == 0){
					System.out.print("|          ");
				}if (row == 0){
					System.out.print ("|" +(char)('A'+j)+"         ");
					if (j == 11){
						System.out.println("|"+(char)('A'+j)+ "         |");
					}
				}
			}
			
		}
		
		
		return null;
	}
}