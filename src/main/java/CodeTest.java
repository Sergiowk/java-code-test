import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;




public class CodeTest {
    private static final String PATHFILETOREAD = "src/main/java/fileToRead.txt";

	public static void main(String[] args){

        //EXERCISE 1
        System.out.println("Exercise 1:\n");
        
        String[] arrayOfNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        
        String[] arrayOfNumbersReverse;
        
        
        System.out.print("Array (Original State): ");
        
        for(String number:arrayOfNumbers) {
    		System.out.print(number + " ");
    	}
        
        arrayOfNumbersReverse = reverseArray(arrayOfNumbers);
        
        System.out.print("\nArray (Reversed State): ");   
        
        for(String number:arrayOfNumbersReverse) {
    		System.out.print(number + " ");
    	}
        
        
        //EXERCISE 2
        System.out.println("\n\nExercise 2:\n");
        String[] arrayOfStrings = {"hello", "my", "friend"};
        
        System.out.print("Array (Original State): ");
	        
        for(String word:arrayOfStrings) {
    		System.out.print(word + " ");
    	}
        String[] arrayOfStringsUpperCase;
        arrayOfStringsUpperCase = uppercaseArray(arrayOfStrings);
        
        System.out.print("\nArray (Upper Case State): ");
        
        for(String word:arrayOfStringsUpperCase) {
    		System.out.print(word + " ");
    	}
        
        //EXERCISE 3
        System.out.println("\n\nExercise 3:\n");
        
        String sentence = "the cat jumped over the mat.";
        String word = "the";
        int wordCount = findWordCount(sentence, word);
        
        System.out.println("{"+ word +"}: " + wordCount);
    	
        //EXERCISE 4
        System.out.println("\nExercise 4:\n");

        Function <Integer, Integer> func = x -> x*2;
        Function <Integer, Integer> func2 = x -> x*3;
        
        Function <Integer, Integer> composeFunction = composeU(func, func2);
        
        System.out.print("composeU: " + composeFunction.apply(5));
        
	    //EXERCISE 5
	    System.out.println("\n\nExercise 5:\n");
	    
	    writeContentsToConsole();
        
	    //EXERCISE 6
        System.out.println("\n\nExercise 6:\n");
        
        handleInvalidArgument();
        
        //PUZZLE
        System.out.println("\n\nPuzzle:");
        
        puzzle();
        
    }
    
    //1. Create a function that accepts an array of numbers and returns a reversed array (e.g. [1,2,3] would be [3,2,1]
    public static String[] reverseArray(String[] input) {
    	
    	String[] arrayReversed = new String[input.length];
    	
    	
    	for(int i=0; i < input.length  ;i++) {
    		//Reversing
    		arrayReversed[i] = input[(input.length-1)-i];

    	}
    	
        return arrayReversed;
    }
    
    //2. Write a function that transforms an array of strings to an upper-case array of strings
    public static String[] uppercaseArray(String[] input) {
    	
    	List<String> inputList = Arrays.asList(input);
    	
    	input = inputList.stream().map(String::toUpperCase).toArray(String[]::new);

        return input;
    }
    
    //3. Given a sentence create a function that returns the number of unique words (e.g. 'the cat jumped over the mat' would be [{'the': 2}, {'cat': 1}…]
    public static int findWordCount(String text, String wordToFind) {
    	//Split every word
        String[] wordsSeparated = text.split("\\s+");
        
        for(int i=0; i<wordsSeparated.length;i++) {
            //Avoiding any character different to a word 
            wordsSeparated[i] = wordsSeparated[i].replaceAll("[^\\w]", "");
        }

        int repeated=0;
        for(String word:wordsSeparated) {
    		if(word.equals(wordToFind)) {
    			repeated++;
    		}
    	}
    
        return repeated;
    }
    
    //4. Write a function 'composeu' that takes two unary functions and returns a unary function that calls them both. A unary function has a single argument and a single return value (e.g. f(d) { return d + 1}
    public static Function<Integer,Integer> composeU(Function<Integer,Integer> f1, Function<Integer,Integer> f2){
    	
    	Function <Integer, Integer> result = f1.andThen(f2);
    	
        return result;
        
    }
    
    //5. Write a function that reads from a file and prints the contents to the console
    public static void writeContentsToConsole() {
    	
    	System.out.println("Reading the file: " + PATHFILETOREAD);
    	
    	try {
    		FileReader fr = new FileReader(PATHFILETOREAD);
    		int character = 0;
    		while((character=fr.read())!=-1) {
    			System.out.print((char)character);
    		}
    		fr.close();
    	}catch (FileNotFoundException e){
    		System.out.print("File not found " + e);
    	}catch(IOException e) {
    		System.out.print("File not openable (File corrupted): " + e);
    	}catch(Exception e) {
    		System.out.print("Issue reading the file: " + e);
    	}
    	
    	
    }
    
    //6. Give an example of how a function would handle an invalid argument
    public static void handleInvalidArgument() {
    	
    	int[] arrayNumbers = new int[] {1,2,3,4};
    	try {
    		System.out.print("Array values: ");
    		for(int i=0; i<10; i++) {
    			System.out.print(arrayNumbers[i]);
    		}
        	
    	}catch (IndexOutOfBoundsException e){
    		System.out.print("\nWrong array position: " + e.getMessage());
    	}

    }
    
    //Puzzle. Write a console application that accepts a random sequence of numbers and loops through looking for 2 equal, consecutive numbers. When found write 'Snap' to the console else print out the number (e.g. 1,3,5,5,'Snap').
    public static void puzzle() {
    	
		System.out.println("\nLet's play");
    	
		
    	System.out.print("Please write consecutive numbers");
    	Scanner input = new Scanner(System.in);
    	try {
    		long numbers = input.nextLong();
    		
    		//Going through the values and checking the previous value
    		for(int number=0; number<String.valueOf(numbers).length(); number++) {
    			
    			if(number==String.valueOf(numbers).length()-1) {
    				//Last Value
    				System.out.print(String.valueOf(numbers).charAt(number));
    			}else {
    				//Not last value
    				System.out.print(String.valueOf(numbers).charAt(number) + ", ");
    			}
    			
    			
    			
    			if((number!=0) && ((String.valueOf(numbers).charAt(number) == String.valueOf(numbers).charAt(number-1)))){
    				//Last Value
    				if(number==String.valueOf(numbers).length()-1) {
    					System.out.print(", 'Snap'");
    				}
    				//Not last value
    				else {
    					System.out.print("'Snap', ");
    				}
    			}
    		}
    		
    		
    	}catch (Exception e){
    		System.out.print("Invalid arguments: "+ e);
    	}
    	input.close();
    }
}