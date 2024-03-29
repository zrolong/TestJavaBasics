package com.example.testio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1、处理流
 * 		字节流
 * 字节缓冲流
 * 		buffer`
 * 
 * 字符缓冲流
 *  	buffer
 *  
 *  使用增加方法不能发生多态
 *  
 * @author 北飞的候鸟
 *
 */
public class Demo03 {

	public static void main(String[] args) {
		
		System.out.println("开始");
		File file = new File("D:/迅雷下载/FreeBsd.iso");
		File outFile = new File("D:/迅雷下载/FreeBsd2.iso");
		
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(file));
			OutputStream os= new BufferedOutputStream(new FileOutputStream(outFile));
			
			byte[] buf = new byte[10240];
			int len = 0;
			while(-1 != (len = is.read(buf))){
				os.write(buf, 0, len);
			}
			os.flush();
			os.close();
			is.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("结束");
	}

}
