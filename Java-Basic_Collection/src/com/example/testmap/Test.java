package com.example.testmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		String str = "this is a number of this numbers";
		String[] strs = str.split(" ");
		for(String  s: strs ){
			System.out.print(s + ",");
		}
		Map<String,Letter> letters = new HashMap<String, Letter>();
		for(String temp : strs){
			if( !letters.containsKey(temp) ){
				letters.put(temp,new Letter());
			}
		}
		for(String temp : strs){
			Letter col = letters.get(temp);
			col.setName(temp);
			col.setCount(col.getCount() + 1);
		}
		Set<String> set = letters.keySet();
		for(String s : set){
			
			System.out.println(letters.get(s).getName() + " " + letters.get(s).getCount());
		}
		
	}
}
