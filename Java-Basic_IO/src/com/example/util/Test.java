package com.example.util;


public class Test {

	public static void main(String[] args) {

		SplitFile file = new SplitFile("C:\\Users\\北飞的候鸟\\Desktop\\新建文件夹\\test.txt", 50,
				"C:\\Users\\北飞的候鸟\\Desktop\\新建文件夹");

		System.out.println(file.size);

		file.split("C:\\Users\\北飞的候鸟\\Desktop\\新建文件夹");

		file.margeFile("C:\\Users\\北飞的候鸟\\Desktop\\新建文件夹\\123.txt");
	}
}
