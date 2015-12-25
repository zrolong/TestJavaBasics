package com.example.generic;

import java.io.Closeable;
import java.io.IOException;

/**
 * 
 * 0�����ͷ������� ��������ǩ��
 * 
 * 1�����ͷ���ֻ�ܷ��ʶ������Ϣ�������޸���Ϣ
 * 
 * @author ���ɵĺ���
 *
 */
public class TestMethod {

	public static <T> void test(T a){
		System.out.println(a);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Closeable> void test(T...a){
		
		for(T temp : a){
			try {
				if(temp != null){
					temp.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		test(123);
	}

}