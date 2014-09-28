/*
 * SplitNumbers.java
 * March 17, 2014
 * 
 * This program reads a text file containing positive integers. The integers are then saved
 * in a linked list in the order they appear. Then the program prints out 'yes' if the integers
 * can be divided into two subsets with different divisors or 'no' if the integers are in less
 * than or more than two subsets.
 */

import java.io.*;

public class SplitNumbers {
	private static int placeHolder = 0;
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String input = "";
		int number;
		boolean split = false;
		LinkedList numList = new LinkedList();
		
		input = getTxtInput();
		
		//Parses out the integers and stores each integer in a linked list node
		while (placeHolder < input.length()){
			number = parseString(input);
			if (number != 0){
				numList.add(number);
			}
		}
		
		split = numList.twoSubsets();
		if (split == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	
	/**
	 * Store input from text file in a string
	 * @return
	 * @throws IOException
	 */
	private static String getTxtInput () throws IOException{
		String inputString = "";
		FileInputStream txtInput = null;
		
		try{
			txtInput = new FileInputStream("in.txt");
			
			int r;
			while ((r = txtInput.read()) != -1){
				inputString += (char) r;
			}
		} 
		catch (IOException err) {
			System.out.println(err.getMessage());
		}
		finally {
			if (txtInput != null){
				txtInput.close();
			}
		}
		
		return inputString;
	}

	/**
	 * Parse an integer out of a string at the location indicated by the placeholder variable
	 * @param input
	 * @return
	 */
	private static int parseString (String input){
		String stringNum = "";
		int number = 0;
		int i = placeHolder;
		char ch = input.charAt(i);
		
		while (ch != ' ' && ch != '\n' && ch != '\r' && i <= input.length()){
			stringNum += Character.toString(ch);
			i++;
			if (i < input.length())
				ch = input.charAt(i);
			else
				ch = ' ';
		}
		
		if (stringNum != ""){
			number = Integer.parseInt(stringNum);
			placeHolder = i + 1;
			return number;
		}
		placeHolder = i + 1;
		return 0;
	}

}
