package com.example.testannation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public class TestDemo {
	
	 	@Override
	 	public String toString(){
	 		return "";
	 	}

	 	@Deprecated
	 	public static void test001(){
	 		System.out.println("test001");
	 	}
	 	

	 	
	 	public static void test002(){
	 		List list = new ArrayList();
	 		List list2 = new ArrayList();
	 		
	 	}
	 	
	 	public static void main(String[] args) {
	 		Date d = new Date();
	 		test001();
	 	}
	 	

}
