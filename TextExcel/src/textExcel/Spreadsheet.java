package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	
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

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
