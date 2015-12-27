package com.example.testreference;

import java.lang.ref.WeakReference;

/**
 * ���÷��ࣺǿ������������ ǿ��������
 * 
 * @author ���ɵĺ���
 *
 */
public class Test {

	public static void main(String[] args) {
		// tsetStringConstant();
		tsetStringReference();

	}
	public static void tsetStringReference() {
		String str = new String("123456789");
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc����ǰ��" + wr.get());
		str = null;
		System.gc();
		System.runFinalization();
		System.out.println("gc���к�" + wr.get());
	}

	public static void tsetStringConstant() {
		String str = "123456789";
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc����ǰ��" + wr.get());
		str = null;
		System.gc();
		System.runFinalization();
		System.out.println("gc���к�" + wr.get());
	}

}