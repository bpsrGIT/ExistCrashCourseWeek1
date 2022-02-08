package Exercises;

import java.util.Random;
import java.util.Scanner;

public class WeekOne {

	public static void main(String[] args) {
		collectData();
	}
	
	static Random random = new Random();
	static Scanner scanner = new Scanner(System.in);
	
	private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private static Integer noOfRow;
	private static Integer noOfCol;
	private static int input = 0;
	private static String[][] array;
	private static String[][] newArray;
	private static String searchInput;
	private static String chToReplace;
	private static String newCh;
	private static String searchCompare;
	private static int instances = 0;

	//CAPTURE USER INPUT
	private static void collectData() {
		System.out.println("Please enter no. of rows:");
		noOfRow = scanner.nextInt();
		System.out.println("Please enter no. of columns:");
		noOfCol = scanner.nextInt();

		createArray();
		
	}
	
	//CREATE ARRAY
	private static void createArray() {
		String[][] arrayInput = new String[noOfCol][noOfRow];
		array = arrayInput;
		array = printTable();
		
		
	}
	
	//PRINT PER ROW
    public static void printRow(String[] row) {
        for (String i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
    
    //SET RANDOM VALUES and PRINT
    public static String[][] printTable() {
        int i, j = 1;

        for(i = 0; i < noOfCol; i++) {
            for( j = 0; j < noOfRow; j++) {
            	String k = "" + alphabet.charAt(random.nextInt(alphabet.length())) + alphabet.charAt(random.nextInt(alphabet.length())) + alphabet.charAt(random.nextInt(alphabet.length()));
                array[i][j] = k;
            }
        }
        return array;
    }
	
    //FUNCTION
	private static void function() {		
		System.out.println("Please type function");
		System.out.println("1 - Search:");
		System.out.println("2 - Edit:");
		System.out.println("3 - Print:");
		System.out.println("4 - Reset:");
		System.out.println("5 - Exit:");
		input = scanner.nextInt();
		
		switch (input) {
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
			toReset();
			break;
		}
		case 5: {
			toExit();
			break;
		}
		default:
			System.out.println("Please choose another option");
			createArray();
			break;
		}
		
	}
		
	//SEARCH
	private static void toSearch() {
		System.out.println("Search function: (please type what to search)");
		searchInput = scanner.next().toLowerCase();
		
        for(int i = 0; i < noOfCol; i++) {
            for(int j = 0; j < noOfRow; j++) {
				for(int k = 0; k < array[i][j].length(); k++){
					searchCompare = String.valueOf(array[i][j].charAt(k));
					if(searchInput.contains(searchCompare) == true) {
						instances = instances + 1;
					}
				}
				
				if (array[i][j].contains(searchInput) == true) {
					System.out.printf("Found %s on (%d,%d) with %d instance/s", searchInput, i, j, instances).println();
					instances = 0;
				}
			}
		}
        System.out.println();
        function();
	}
	
	//EDIT
	private static void toEdit() {
		System.out.println("What character would you like to replace?");
		chToReplace = scanner.next();
		System.out.println("Please enter new character");
		newCh = scanner.next();
		
		editedArray();
		array = newArray;

        System.out.println();
        function();
	}
	
    public static String[][] editedArray() {
    	newArray = array;
        for(int i = 0; i < noOfCol; i++) {
            for(int j = 0; j < noOfRow; j++) {
            	for(int k = 0; k < newArray[i][j].length(); k++){
            		searchCompare = String.valueOf(newArray[i][j].charAt(k));
					if(chToReplace.contains(searchCompare) == true) {
						newArray[i][j] = newArray[i][j].replace(chToReplace, newCh);
					}
            	}
			}
		}
        return newArray;
    }
	
	//PRINT
	private static void toPrint() {
        for(String[] row : array) {
            printRow(row);
            
        }
        function();
		
	}
	
	//RESET
	private static void toReset() {
		noOfRow = 0;
		noOfCol = 0;
		input = 0;
		array = null;
		collectData();
	}
	
	//EXIT
	private static void toExit() {
		System.out.println("See you again!");
		System.exit(0);
	}
}
