package com.example.testmtest;

import java.util.Iterator;

import com.example.testarraylist.MyArrayList_;

public class Test_ {

	public static void main(String[] args) {
		MyArrayList_ list = new MyArrayList_();
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}