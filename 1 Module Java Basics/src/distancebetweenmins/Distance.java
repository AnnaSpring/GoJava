package distancebetweenmins;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Distance {
	public static void main(String[] args) throws Exception{
		
		ArrayList<Integer> list = userInputDigits();
		for(Integer i : list){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
		System.out.println(findMinsInArray(distance(list)));

		
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
	
	public static ArrayList<Integer> findMinsInArray(ArrayList<Integer> list){
		int min = list.get(0);
		ArrayList<Integer> listOfMins = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++){
			if(min > list.get(i)){
				min = list.get(i);
			}
		}
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) == min)
				listOfMins.add(i);
		}
		
		if(listOfMins.size() < 2){
			int min2 = list.get(0);
			for(int i = 0; i < list.size(); i++){
				if(list.get(i) != min){
					if(list.get(i) < min2)
						min2 = list.get(i);
				}
			}
			
			for(int i = 0; i < list.size(); i++){
				if(list.get(i) == min2)
					listOfMins.add(i);
			}
		}
		return listOfMins;
	}
	
	private static ArrayList<Integer> distance(ArrayList<Integer> list){
		ArrayList<Integer> dist = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++){
			dist.add(list.get(i + 1)-list.get(i));
		}
		return dist;
	}
}
