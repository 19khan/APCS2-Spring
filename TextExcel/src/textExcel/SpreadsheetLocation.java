package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location{
	private String location;
	
    public SpreadsheetLocation(String cellName){
    	this.location = cellName;
    }
    
    public int getRow(){
        return (Integer.parseInt(this.location.substring(1)))-1;
    }

    public int getCol(){
    	return this.location.charAt(0)-'A';
    }
}
