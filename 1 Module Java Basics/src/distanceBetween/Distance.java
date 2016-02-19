package distanceBetween;

import java.io.*;
import java.util.*;

public class Distance {
	public static void main(String[] args) throws Exception{
		ArrayList<Integer> list = new ArrayList<Integer>();
		inputDigits(list);
		
		
	}
	
	public static ArrayList<Integer> inputDigits(ArrayList<Integer> list) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string;
		int number;
		
		
		System.out.println("How many numbers will array contain?");
		String size = reader.readLine();
		int arraySize = Integer.parseInt(size);
		
		for(int i = 0; i < arraySize; i++){
				string = reader.readLine();
				number = Integer.parseInt(string);
				list.add(number);
				
		}
		
		return list;
	}
}
