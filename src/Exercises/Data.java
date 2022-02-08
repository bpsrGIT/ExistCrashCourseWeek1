package Exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Data {
	private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

	static Random random = new Random();
	static Scanner scanner = new Scanner(System.in);
	
	public static String randomKey() {
		return "" + alphabet.charAt(random.nextInt(alphabet.length())) + alphabet.charAt(random.nextInt(alphabet.length())) + alphabet.charAt(random.nextInt(alphabet.length()));
	}

	public static String randomValue() {
		return "" + alphabet.charAt(random.nextInt(alphabet.length())) + alphabet.charAt(random.nextInt(alphabet.length())) + alphabet.charAt(random.nextInt(alphabet.length()));
	}

	private static Integer noOfRow;
	public static Integer getNoOfRow() {
		return noOfRow;
	}
	public static void setNoOfRow(Integer noOfRow) {
		Data.noOfRow = noOfRow;
	}
	
	private static Integer noOfCol;
	public static Integer getNoOfCol() {
		return noOfCol;
	}
	public static void setNoOfCol(Integer noOfCol) {
		Data.noOfCol = noOfCol;
	}
	
	private static Integer functionNumber;
	public static Integer getFunctionNumber() {
		return functionNumber;
	}
	public static void setFunctionNumber(Integer functionNumber) {
		Data.functionNumber = functionNumber;
	}
	
	private static String searchInput;

	public static String getSearchInput() {
		return searchInput;
	}
	public static void setSearchInput(String searchInput) {
		Data.searchInput = searchInput;
	}

	private static List<HashMap<String, String>> tableArray;
	public static List<HashMap<String, String>> getTableArray() {
		return tableArray;
	}
	public static void setTableArray(List<HashMap<String, String>> array) {
		Data.tableArray = array;
	}
	
	private static List<HashMap<String, String>> newArray;
	public static List<HashMap<String, String>> getNewArray() {
		return newArray;
	}
	public static void setNewArray(List<HashMap<String, String>> newArray) {
		Data.newArray = newArray;
	}


	//	private static String searchInput;
	private static String valueToReplace;
	public static String getValueToReplace() {
		return valueToReplace;
	}
	public static void setValueToReplace(String replace) {
		Data.valueToReplace = replace;
	}


	private static String newValue;
	public static String getNewValue() {
		return newValue;
	}
	public static void setNewValue(String value) {
		Data.newValue = value;
	}
	
	private static Integer additionalRow;
	public static Integer getAdditionalRow() {
		return additionalRow;
	}
	public static void setAdditionalRow(Integer additionalRow) {
		Data.additionalRow = additionalRow;
	}
	
	public static String tempString;
	public static String getTempString() {
		return tempString;
	}

	public static void setTempString(String tempString) {
		Data.tempString = tempString;
	}
	
	public static int instances;
	public static int getInstances() {
		return instances;
	}
	public static void setInstances(int instances) {
		Data.instances = instances;
	}

	public static void collectData() {
		System.out.println("Please enter no. of rows:");
		setNoOfRow(scanner.nextInt());
		System.out.println("Please enter no. of columns:");
		setNoOfCol(scanner.nextInt());

		createArray();
	}
	
	public static void createArray() {
		List<HashMap<String, String>> array = new ArrayList<HashMap<String, String>>();
		
		for(int i = 0; i < getNoOfCol(); i++) {
			
			HashMap<String, String> row = new HashMap<>();
			
			for(int j = 0; j < getNoOfRow(); j++) {
				
				row.put(randomKey(), randomValue());
			}
			
			array.add(row);
			
		}
		setTableArray(array);
	}




	public static void editedArray() {
    	setNewArray(getTableArray());
    	
    	for(HashMap<String, String> row : getNewArray()) {
    		
    		for(Map.Entry<String, String> set : row.entrySet()) {
    			
    			if(set.getValue().contains(getValueToReplace())) {
    				
    				row.put(set.getKey(), getNewValue());
    				
    			}
    			if(set.getKey().contains(getValueToReplace())) {
    				row.replace(getNewValue(), set.getValue());
    			}
    		}
    	}
    	setTableArray(getNewArray());
    }





}
