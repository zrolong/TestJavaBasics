package com.example.testexception;

/**
 * 1��Throwable
 *  --Error 
 *  --Exception {checkedException && uncheckedExcrption} 
 * 
 * 
 * 2����ָ������Д��Ƿ���
 * 
 * 3�����಻�ܳ�������ķ�Χ
 * 
 * @author ���ɵĺ���
 *
 */
public class Test {

	
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// uncheckedExcrption
		try {
			int i = 6 / 0;
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("����Ϊ'0'");
		}
		// checkedException
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//��ָ����Д಻���a؛
		TestClass testClass = null;
		if(testClass != null){
			testClass.start();
		}else{
			return;
		}

	}

	class TestClass {
		public void start() {
			System.out.println("start");
		}
	}
}