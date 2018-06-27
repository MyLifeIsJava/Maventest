package com.kiransringeri.maven.test;

public class SecondMavenClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getString() {
		return getClass().getSimpleName();
	}
	
	public int getZero() {
		return 0;
	}
	
	public int multiply(int x, int y) {
		return x * y;
	}
	
	public int divide(int x, int y) {
		if(y == 0)
			throw new IllegalArgumentException("Zero not allowed");
		return x / y;
	}
}
