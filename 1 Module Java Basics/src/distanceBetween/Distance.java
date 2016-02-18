package distanceBetween;

import java.io.*;
import java.util.*;

public class Distance {
	public static void main(String[] args) throws Exception{
		ArrayList<Integer> list = new ArrayList<Integer>();
		inputDigits(list);
		for(int i = 0; i< list.size(); i++){
			System.out.println(list.get(i));
			System.out.println(list.get(i));
		}
		
	}
	
	public static ArrayList<Integer> inputDigits(ArrayList<Integer> list) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string;
		int number;
		string = reader.readLine();
		if(!string.equals(null)){
			while(true){
				string = reader.readLine();
				number = Integer.parseInt(string);
				list.add(number);
				if(string.equals(null))
					System.out.println("Incorrect input");
			}
		}
		else
			System.out.println("Incorrect input");
		
		return list;
	}
}
