package com.example.test_jvm;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
	
	
		System.out.println(System.getProperty("java.class.path"));
		
		String a = "aaaaa";
		System.out.println(a.getClass().getClassLoader());
		System.out.println(a);
	}
}