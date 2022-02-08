package Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Functions {
	static Scanner scanner = new Scanner(System.in);

	  //FUNCTION
		public static void SelectFunction() {		
			System.out.println("Please type function");
			System.out.println("1 - Search:");
			System.out.println("2 - Edit:");
			System.out.println("3 - Print:");
			System.out.println("4 - Additional Row:");
			System.out.println("5 - Concat and Sort:");
			System.out.println("6 - Reset:");
			System.out.println("7 - Exit:");
			
			Data.setFunctionNumber(scanner.nextInt());
			
			switch (Data.getFunctionNumber()) {
			case 1: {
				toSearch();
				break;
			}
			case 2: {
				toEdit();
				break;
			}
			case 3: {
				toPrint();
				break;
			}
			case 4: {
				addRow();
				break;
			}
			case 5: {
				concatArray();
				break;
			}
			case 6: {
				toReset();
				break;
			}
			case 7: {
				toExit();
				break;
			}
			default:
				System.out.println("Please choose another option");
				Data.createArray();
				break;
			}
			
		}
			
		//SEARCH
		private static void toSearch() {
			System.out.println("Search function: (please type what to search)");
			Data.setSearchInput(scanner.next());
			
	    	for(HashMap<String, String> row : Data.getTableArray()) {
	    		int setIndex = 0;
	    		for(Map.Entry<String, String> set : row.entrySet()) {
	    			
	    			if(set.getKey().contains(Data.getSearchInput())) {
	    				String str = set.getKey().toString();
	    				String str2 = Data.getSearchInput();
	    				int instance = 0;
	    				for(int i = 0; i<str.length(); i++) {
	    					if(str.substring(i, str2.length() +i) == str2) {
	    						instance = instance +1;
	    						
	    					}
	    				}
	    				
	    				
	    				
	    				
	    				System.out.printf("Found %s on (%d,%d) with %d instance/s on 'Key' column", Data.getSearchInput(), Data.getTableArray().indexOf(row), setIndex, Data.getInstances()).println();
	    				Data.setInstances(0);
	    			}

	    			if(set.getValue().contains(Data.getSearchInput())) {
	    				int instance = 0;
	    				System.out.printf("Found %s on (%d,%d) with %d instance/s on 'Value' column", Data.getSearchInput(), Data.getTableArray().indexOf(row), setIndex, instance).println();
	    				instance = 0;
	    			}
    				setIndex++;
	    		}
	    	}
	        System.out.println();
	        SelectFunction();
		}
		
		//EDIT
		private static void toEdit() {
			System.out.println("What character would you like to replace?");
			Data.setValueToReplace(scanner.next());
			System.out.println("Please enter new character");
			Data.setNewValue(scanner.next());
			Data.editedArray();

	        System.out.println();
	        toPrint();
	        System.out.println();
	        SelectFunction();
		}
		

		
		//PRINT
		public static void printRow(HashMap<String, String> row) {
	    	
	    	for (Iterator<Entry<String, String>> iterator = row.entrySet().iterator(); iterator.hasNext();) {
				Entry<String, String> i = iterator.next();
				System.out.print(i.getKey() + ", " + i.getValue());
	            System.out.print("\t");
			}
	        System.out.println();
	    }
		public static void toPrint() {
	        for(HashMap<String, String> row : Data.getTableArray()) {
	            printRow(row);
	        }
	        SelectFunction();
		}
		
		//ADD ROW
		public static void addRow() {
			Data.setNewArray(Data.getTableArray());
			
			System.out.println("How many row/s to add");
			Data.setAdditionalRow(scanner.nextInt());
			
			for(HashMap<String, String> row : Data.getNewArray()) {
				for(int i = 0; i < Data.getAdditionalRow(); i++) {
					row.put(Data.randomKey(), Data.randomValue());
				}
			}
			Data.setTableArray(Data.getNewArray());
			SelectFunction();
		}
		
		//CONCAT and SORT
		public static void concatArray() {
			Data.setNewArray(Data.getTableArray());
			
			
			for(HashMap<String, String> row : Data.getNewArray()) {
				StringBuilder arrayString = new StringBuilder("");
			    for(Map.Entry<String, String> tempSet : row.entrySet()) {
			    	Data.setTempString(tempSet.getKey() + "" + tempSet.getValue());
				   	char tempArray[] = Data.getTempString().toCharArray();

				    char temp;
				        
				    int i = 0;
				        
				    while (i < tempArray.length) {
				        int j = i + 1;
				        while (j < tempArray.length) {
				            if (tempArray[j] < tempArray[i]) {
				                    temp = tempArray[i];
				                    tempArray[i] = tempArray[j];
				                    tempArray[j] = temp;
				                }
				                j += 1;
				            }
				            i += 1;
				        }
				        
				        String str = new String(tempArray);
				    	
				        arrayString.append(str + " ");
			    	}

			    arrayString.delete(arrayString.length(), arrayString.length()).append("");
			    
			    System.out.println(arrayString.toString());

			}
			System.out.println();
			SelectFunction();
		}
		
		//RESET
		private static void toReset() {
			Data.setNoOfRow(0);
			Data.setNoOfCol(0);
			Data.setTableArray(null);
			Data.setFunctionNumber(0);
			Data.collectData();
		}
		
		//EXIT
		private static void toExit() {
			System.out.println("See you again!");
			System.exit(0);
		}
		
}
