import java.io.*;
import java.util.*;

public class TemperatureDifference {
	public static void main (String args []) throws FileNotFoundException{
		Scanner input = new Scanner (new File("./resources/weather.txt"));
		ArrayList <Double> data = new ArrayList<Double>();
				
		while (input.hasNext() == true){
			data.add(input.nextDouble());
			if (input.hasNext() == false){
				break;
			}
		}	
		for (int i = 0; i < data.size()-1; i++){
			System.out.println (data.get(i)+" to " + data.get(i+1) +", change = "+ (data.get(i+1) - data.get(i)));
		}
	}
}
