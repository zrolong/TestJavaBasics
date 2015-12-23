package com.example.collection;

import java.util.HashMap;

/**
 * 1��idea
 * 
 * @author ���ɵĺ���
 *
 */
public class MyHashSet {
	
	protected HashMap<Object,Object> map;
	private static final Object PRESENT = new Object();

	public MyHashSet(){
		map = new HashMap<Object,Object>();
	}
	
	
	public int getSize() {
		return map.size();
	}


	public void add(Object obj){
		map.put(obj, PRESENT);
	}
	
	public static void main(String[] args) {
		
		MyHashSet set = new MyHashSet();
		set.add("1");
		
		System.out.println(set.getSize());
	}
}
