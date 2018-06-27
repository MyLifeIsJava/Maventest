package com.kiransringeri.maven.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FirstMavenClassTest {

	@Test
	public void testGetString() {
		FirstMavenClass obj = new FirstMavenClass();
		assertEquals("Name do not match", "FirstMavenClass", obj.getString());
	}

}
