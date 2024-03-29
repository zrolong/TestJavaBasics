package com.example.testfile;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 1、mkdirc创建目录，确保父目录存在
 * 2、mkdis 创建目录，如果父目录不存在，则创建
 * 3、list（） 文件目录
 * 4、listFile（）文件格式的目录
 * @author 北飞的候鸟
 *
 */

public class Demo02 {

	public static void main(String[] args) {
		
		File file = new File("D:\\and_tools\\android-sdk-windows");
		String[] files = file.list();
		for(String s : files){
			System.out.println(s);
		}
		
		System.out.println("*******************************************");
		File[] subFile = file.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt") && dir.isFile();
			}
		});
		for(File f : subFile){
			System.out.println(f.getName());
		}
	}
}
