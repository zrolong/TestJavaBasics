package com.example.testsingle;

/**
 * �����Ĵ�����ʽ
 * 1������ʽ
 * 		������˽�л�
 * 		����˽�еľ�̬����
 * 		�����ṩ�������Եľ�̬������ȷ���ö������
 * 
 * 
 * 2����ʽ
 * 
 * 		������˽�л�
 * 		����˽�еľ�̬���ԣ�ͬʱ����
 * 		�����ṩ�������Եľ�̬������ȷ���ö������
 * 
 * 
 * 3���ý���Ķ�ʽ
 * 
 * 		�ṩ�������˽���࣬���ڼ��ڵ�ʱ�򴴽�
 * 
 * @author ���ɵĺ���
 *
 */
public class TestSingles {


	private static TestSingles instance = null;
	
	private TestSingles(){
		
	}
	
	public static TestSingles getInstance(){
		if(instance == null){
			instance = new TestSingles();
		}
		return instance;
	}
	
	public void print(){
		System.out.println("single dog ");
	}
	
	public static void main(String[] args) {
		
	}
	
}

class TestSingles_1{
	
private static TestSingles_1 instance = new TestSingles_1();
	
	private TestSingles_1(){
		
	}
	
	public static TestSingles_1 getInstance(){
		return instance;
	}
	
	public void print(){
		System.out.println("single dog ");
	}
	
	public static void main(String[] args) {
		
	}
	
}

/**
 * �ý���ĵ���ģʽ
 * ����ʹ�õ�ʱ�����
 * �ӳټ���
 * 
 * @author ���ɵĺ���
 *
 */

class TestSingles_2{
	
	private static class TestSingles_2_Hodle{
		private static TestSingles_2 instance = new TestSingles_2();
	}
	
	private TestSingles_2() {

	}
	
	public static TestSingles_2 getInstance() {
		return TestSingles_2_Hodle.instance;
	}
	
	public void print(){
		System.out.println("single dog ");
	}
	
	public static void main(String[] args) {
		
	}
	
	
}