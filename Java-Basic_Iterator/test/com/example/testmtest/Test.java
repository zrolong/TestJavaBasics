package com.example.testmtest;
import com.example.testarraylist.MyArrayList;


public class Test {

	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		while(list.hasNext()){
			System.out.println(list.next());
		}

		for(Integer i : list){
			System.out.println(i);
		}
		
	}
	
}
