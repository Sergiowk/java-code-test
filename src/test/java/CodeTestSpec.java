import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.Function;

/*
 *   Please code the tests in the format of reverseArray_returnsExpectedResult. This is an example of how we write our tests at Cardano.
 *
 *   Test 1-4 tests are easy as the function returns a result that can be asserted. Tests 5-7 are more difficult to assert as they are
 *   void, use your knowledge to write a meaningful test.
 *
 *   Feel free to use the internet to help you with you answers but make sure you understand the answer as we will ask you questions.
 */

public class CodeTestSpec {
	
	//EXERCISE 1
	
    @Test
    public void reverseArray_returnsExpectedResult_success() {
        // arrange
        final String[] EXPECTED = {"x", "y", "z"};

        // act
        final String[] actual = CodeTest.reverseArray(new String[] {"z", "y", "x"});

        // assert
        assertArrayEquals(EXPECTED, actual);
    }

    //EXERCISE 2
    
    @Test
    public void uppercaseArray_returnsExpectedResult_success() {
    	// arrange
        final String[] EXPECTED = {"NICE", "TO", "MEET", "YOU"};

        // act
        final String[] actual = CodeTest.uppercaseArray(new String[] {"nice", "to", "meet", "you"});
    	
        // assert
        assertArrayEquals(EXPECTED, actual);
    }
    
    @Test
    public void uppercaseArray_allMayus_success_success() {
    	// arrange
        final String[] EXPECTED = {"NICE", "TO", "MEET", "YOU"};

        // act
        final String[] actual = CodeTest.uppercaseArray(new String[] {"NICE", "TO", "MEET", "YOU"});
    	
        // assert
        assertArrayEquals(EXPECTED, actual);
    }
    
    @Test
    public void uppercaseArray_upperAndLowerCaseWords_success() {
    	// arrange
        final String[] EXPECTED = {"NICE", "TO", "MEET", "YOU"};

        // act
        final String[] actual = CodeTest.uppercaseArray(new String[] {"NiCe", "to", "MeeT", "YOu"});
    	
        // assert
        assertArrayEquals(EXPECTED, actual);
    }
    
    @Test
    public void uppercaseArray_withSpaces_fail() {
    	// arrange
        final String[] EXPECTED = {"NICE", "TO", "MEET", "YOU"};

        // act
        final String[] actual = CodeTest.uppercaseArray(new String[] {"ni ce", "t o", "mee t", "yo u"});
    	
        // assert
        assertArrayEquals(EXPECTED, actual);
    }
    
    //EXERCISE 3
    
    @Test
    public void findWordCount_returnsExpectedResult() {
    	
    	final Integer EXPECTED = 6;
    	
    	
    	final Integer result = CodeTest.findWordCount("can you can a can as a canner can can a can?", "can");
    	
    	assertEquals(EXPECTED, result);
    }
    
    //EXERCISE 4
    
    @Test
    public void composeU_returnsExpectedResult() {
    	
    	final Function <Integer, Integer> func = x -> x+1;
    	final Function <Integer, Integer> func2 = x -> x+2;
    	final Function <Integer, Integer> composeFunctionTest = CodeTest.composeU(func, func2);
    	
    	final Function outputFunc = CodeTest.composeU(func, func2);
    	final Integer result = 5;
    	
    	assertEquals(composeFunctionTest.apply(2),  result);
    }
    
    //EXERCISE 5
    
    @Test
    public void writeContentsToConsole_returnsExpectedResult() {
    	
    	final String EXPECTED = "Reading the file: src/main/java/fileToRead.txt\r\n"
    			+ "Hello all,\r\n"
    			+ "\r\n"
    			+ "Hope everything is well.\r\n"
    			+ "\r\n"
    			+ "Nice to meet you\r\n"
    			+ "\r\n"
    			+ "Best regards";
    	
    	//Console output
    	final PrintStream output = System.out;
    	final ByteArrayOutputStream outputStream= new ByteArrayOutputStream();
    	System.setOut(new PrintStream(outputStream));
    	CodeTest.writeContentsToConsole();
    	final String actual = outputStream.toString();
        
    	assertEquals(EXPECTED, actual);
    	
    	System.setOut(output);
    	
    }
    
    //EXERCISE 6
 
    @Test
    public void handleInvalidArgument_returnsExpectedResult() {
    	final String EXPECTED = "Array values: 1234\n"
    			+ "Wrong array position: Index 4 out of bounds for length 4";
    	
    	
    	//Console output
    	final PrintStream output = System.out;
    	final ByteArrayOutputStream outputStream= new ByteArrayOutputStream();
    	System.setOut(new PrintStream(outputStream));
    	CodeTest.handleInvalidArgument();
    	final String actual = outputStream.toString();
    	assertEquals(EXPECTED, actual);
    }
    
    //EXERCISE 7
    
    @Test
    public void puzzle_returnsExpectedResult() {
    	
    	final String EXPECTED = "\n"
    			+ "Let's play\r\n"
    			+ "Please write consecutive numbers"
    			+ "1, 1, 'Snap', 2, 3, 4, 4, 'Snap'";


    	
    	//Simulating Scanner data input
    	final InputStream input = System.in; 
    	final ByteArrayInputStream in = new ByteArrayInputStream("112344".getBytes());
    	System.setIn(in);
    	
    	//Console output
    	final PrintStream output = System.out;
    	final ByteArrayOutputStream outputStream= new ByteArrayOutputStream();
    	System.setOut(new PrintStream(outputStream));
    	
    	CodeTest.puzzle();
    	//Introducing data input
    	System.setIn(in);
    	//Getting the output from the console
    	final String actual = outputStream.toString();

    	assertEquals(EXPECTED, actual);

    	System.setOut(output);

    }
}
