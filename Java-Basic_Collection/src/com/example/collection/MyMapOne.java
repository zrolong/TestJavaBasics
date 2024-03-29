package com.example.collection;

/**
 * 1、自己实现map
 * 
 * 
 * 2、主键不能重复
 * 
 * @author 北飞的候鸟
 *
 */
public class MyMapOne {

	MyEntry[] arr = new MyEntry[100];
	int size;

	public void put(Object key, Object valus) {
		MyEntry e = null; 
		for (int i = 0; i < size; i++) {
			if (arr[i].key.equals(key)) {
				arr[i].obj = valus;
				return;
			}
		}
		e = new MyEntry(key, valus);
		arr[size++] = e;
	}

	public Object get(Object key) {
		for (int i = 0; i < size; i++) {
			if (arr[i].key.equals(key)) {
				return arr[i].obj;
			}
		}
		return null;
	}

	public boolean conainsKey(Object key) {

		for (int i = 0; i < size; i++) {

			if (arr[i].key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		MyMapOne mapOne = new MyMapOne();
		mapOne.put(1, 1);
		mapOne.put(2, 2);
		mapOne.put(3, 3);

		System.out.println(mapOne.get(2));
		System.out.println(mapOne.conainsKey(2));
	}
}