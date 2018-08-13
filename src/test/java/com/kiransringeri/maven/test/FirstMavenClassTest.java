package com.kiransringeri.maven.test;

/**
 * NOTES:
 * 1. A test should have only 3 lines
 * 		E.g: Given that I have an empty stack,
 * 			 When I add an element to it,
 * 			 The stack size will be 1.
 *    We can push the complexities involved in each of these three lines to utility methods
 *    
 *    
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class FirstMavenClassTest {
		
	@DisplayName("Dummy Test")
	@Test
	public void testJava8Features() {
		FirstMavenClass obj = new FirstMavenClass();
		obj.java8Features();
	}
	
	@DisplayName("Testing Main")
	@Test
	public void Should_Work_When_FileIsPssedToMainMethod() {
		PrintStream stdOut = System.out;
		File outFile = new File("check_output.txt");
		try {
			PrintStream ps = new PrintStream(new FileOutputStream(outFile)); 
			System.setOut(ps);
			FirstMavenClass.main(new String[] {"testing_data/input.txt"});
			ps.flush();
			ps.close();
			System.setOut(stdOut);
			
			String expected = readFile("testing_data/output.txt");
			String actual = readFile(outFile.getName());
			assertEquals(expected, actual);
		}catch(IOException th){
			System.setOut(stdOut);
			th.printStackTrace();
			fail("Failed in main");
		}finally {
			outFile.delete();
		}
//		Test the output
	}
	
	private String readFile(String file) throws IOException{
		StringBuilder buffer = new StringBuilder();
		String line = null;
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((line = br.readLine()) != null) {
			buffer.append(line+"\n");
		}
		br.close();
		return buffer.toString();
	}
//	Should_ExpectedBehavior_When_StateUnderTest
	@DisplayName("Correct input")
	@Test
	public void Should_Work_When_CorrectInputIsGiven() {
		FirstMavenClass obj = new FirstMavenClass();
		assertEquals(3, obj.divideNumbers(18, 6));
	}

	@DisplayName("Divisor is ZERO")
	@Test
	public void Should_ThrowException_When_DivisorIsZERO() {
		final FirstMavenClass obj = new FirstMavenClass();
		Throwable exception = assertThrows(IllegalArgumentException.class, new Executable() {
			public void execute() throws Throwable {
				obj.divideNumbers(5, 0);
			}
		});
        assertEquals("Divisor can't be zero", exception.getMessage());
	}
	
}
