package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel{

	public static void main(String[] args){
	    Spreadsheet cells = new Spreadsheet();
	    
	    cells.getGridText();
	    
		Scanner userInput = new Scanner (System.in);
		String command = userInput.nextLine();
	    while (!userInput.next().equals("quit")){
	    	System.out.println(cells.processCommand(command));
	    	command = userInput.nextLine();
	    }
	}
	
}
