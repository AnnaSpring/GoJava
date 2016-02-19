package anagram;

import java.io.*;

public class Anagram {
	public static void main(String[] args)throws Exception{
		
		System.out.println(outputLine("mama mila ramu"));
		
	}
	

	public static String outputLine(String string){
		return new StringBuilder(string).reverse().toString();
	}

}
