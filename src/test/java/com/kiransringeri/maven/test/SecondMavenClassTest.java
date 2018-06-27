package com.kiransringeri.maven.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SecondMavenClassTest {

//	Use 'should' in method name like 'ordersShouldBeCreated'
//	OR
//	Use 'Given[ExplainYourInput]When[WhatIsDone]Then[ExpectedResult]'
	
	@Test
	public void testGetString() {
		SecondMavenClass obj = new SecondMavenClass();
		assertEquals("Name do not match", "SecondMavenClass", obj.getString());
	}
	
	@Test
	public void testGetZero() {
		SecondMavenClass obj = new SecondMavenClass();
		assertEquals("Zero do not match", 0, obj.getZero());
	}

	// fields used together with @Parameter must be public
    @Parameter(0)
    public int m1;
    @Parameter(1)
    public int m2;
    @Parameter(2)
    public int result;
 // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 1 , 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
        return Arrays.asList(data);
    }
    
    @Test
    public void testMultiplyException() {
    	SecondMavenClass tester = new SecondMavenClass();
        assertEquals("Result", result, tester.multiply(m1, m2));
    }
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void throwsIllegalArgumentIfDivideByZero() {
      exception.expect(IllegalArgumentException.class);
      exception.expectMessage("Zero not allowed");
      SecondMavenClass t = new SecondMavenClass();
      t.divide(2, 0);
    }
    
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testUsingTempFolder() throws IOException {
      File createdFolder = folder.newFolder("newfolder");
      File createdFile = folder.newFile("myfilefile.txt");
      System.out.println("+++++++++++++++++++++++++");
      System.out.println(createdFolder.getAbsolutePath());
      assertTrue(createdFile.exists());
    }
}
