package com.example.generic_;

/**
 * 1������λ������
 * 	1.1������
 *  1.2������
 *  
 *  
 *  
 * 2��Ҫôͬʱ������Ҫô�����ڸ��������
 * 
 * 3����������
 * 		3.1���������游�����
 * 		3.2���������������
 * 
 * 4��������д
 * 		�游�����
 * 
 * @author ���ɵĺ���
 *
 * @param <T>
 */
public abstract class Father<T> {
	
	T name;
	public abstract void test(T t);
}

/**
 * 1������������ʱ���ƶ����������
 * 2����������Ϊ��������
 * 3������ͬ��
 * 
 * @author ���ɵĺ���
 *
 */

class Child extends Father<String>{

	String t2;
	
	@Override
	public void test(String t) {
		
	}
	
}

/**
 * 1������λ������
 * 
 * @author ���ɵĺ���
 *
 */

class Child_<T> extends Father<T>{

	T t2;

	@Override
	public void test(T t) {
		
	}
	
}

/**
 * 1������Ϊ�����࣬���಻ָ������
 * 2�����͵Ĳ�����ʹ��Object�滻
 * 
 * @author ���ɵĺ���
 *
 * @param <T>
 */
@SuppressWarnings("rawtypes")
class Child_2<T> extends Father{

	T name;
	
	@Override
	public void test(Object t) {
		
	}

	
}

/**
 * ����͸���ͬʱ�滻
 * 
 * @author ���ɵĺ���
 *
 */
@SuppressWarnings("rawtypes")
class Child_3 extends Father{

	@Override
	public void test(Object t) {
		
	}
}

/**
 * �����������������ʹ�÷���
 * 
 * 	class Child_2 extends Father<T>{
 * 
 *		@Override
 *		public void test(Object t) {
 *
 *		
 *		}
 *		}
 */
