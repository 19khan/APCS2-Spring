package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel{

	public static void main(String[] args){
	    Spreadsheet cells = new Spreadsheet();
	    
		Scanner userInput = new Scanner (System.in);
		String command = userInput.nextLine();
	    while (!command.toUpperCase().equals("QUIT")){
	    	System.out.println(cells.processCommand(command));
	    	command = userInput.nextLine();
	    }
	}
	
}
