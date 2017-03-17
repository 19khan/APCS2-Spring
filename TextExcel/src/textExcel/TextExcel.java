package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel{

	public static void main(String[] args){
	    Spreadsheet cells = new Spreadsheet();
	    
	    System.out.println(cells.getGridText());
	    
		Scanner userInput = new Scanner (System.in);
		String command = "";
	    while (!command.equals("quit")){
			command = userInput.nextLine();
	    	cells.processCommand(command);
	    	System.out.println(cells.getGridText());
	    }
	}
	
}
