package com.example.teststring;

/**
 * String (���ɱ�) StringBuluder(�̲߳���ȫ��Ч�ʸ�) StringBuffer (�̰߳�ȫ��Ч�ʵ�)
 * 
 * @author ���ɵĺ���
 *
 */
public class TsetStringBulider {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		long flag = 0;
		for (int i = 0; i < 100000; i++) {
			sb = sb.append(i);
			if(flag != sb.hashCode()){
				System.out.println(sb.hashCode());
			}
			flag = sb.hashCode();
		}
		System.out.println(sb);
	}
}