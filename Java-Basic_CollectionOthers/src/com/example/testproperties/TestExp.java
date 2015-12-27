package com.example.testproperties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ���
 * 
 * @author ���ɵĺ���
 *
 */
public class TestExp {

	public static void main(String[] args) {
		
		Properties pro = new Properties();
		pro.setProperty("1","1");
		pro.setProperty("2","2");
		pro.setProperty("3","3");
		pro.setProperty("4","4");
		
		try {
			pro.store(new FileOutputStream(new File("src/com/example/"
					+ "testproperties/pro.properties")),
					"��������");
			pro.storeToXML(new FileOutputStream(new File("src/com/example/"
					+ "testproperties/db.xml")),
					"��������");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}