package distanceBetween;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Distance {
	public static void main(String[] args) throws Exception{
		
		ArrayList<Integer> list = userInputDigits();
		for(Integer i : list){
			System.out.print(i + " ");
		}
		
		
	}
	
	public static ArrayList<Integer> userInputDigits() throws Exception {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String string = reader.readLine();
		String[] arrayOfStrings = string.split(" ");
		try{
			for(int i = 0; i < arrayOfStrings.length; i++){
				list.add(Integer.parseInt(arrayOfStrings[i]));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
	
}
