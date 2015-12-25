package com.example.generic;

/**
 * 1��������:��������ʱ��ʹ�÷���
 * 2����ĸ
 * 		T   Type ��ʾ����
 * 		K , V  �ֱ��ʾ��ֵ�е�Key���� Value
 * 		E      ��ʾElement
 * 
 * Student<T��T1��T2>
 * 
 * ʹ�õ�ʱ��ȷ��
 * 
 * 3������ֻ����һ�����ͣ������û�������
 * 4������ʹ��ʱ������ʹ�þ�̬���ԣ���̬������
 * 
 * @author ���ɵĺ���
 *
 * @param <T>
 */
public class Student<T> {
	
	private T javase;
	private T oracle;
	
	
	public Student() {
		
	}
	

	public Student(T javase, T oracle) {
		super();
		this.javase = javase;
		this.oracle = oracle;
	}




	public T getJavase() {
		return javase;
	}


	public void setJavase(T javase) {
		this.javase = javase;
	}


	public T getOracle() {
		return oracle;
	}


	public void setOracle(T oracle) {
		this.oracle = oracle;
	}


	@Override
	public String toString() {
		return "Student [javase=" + javase + ", oracle=" + oracle + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((javase == null) ? 0 : javase.hashCode());
		result = prime * result + ((oracle == null) ? 0 : oracle.hashCode());
		return result;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (javase == null) {
			if (other.javase != null)
				return false;
		} else if (!javase.equals(other.javase))
			return false;
		if (oracle == null) {
			if (other.oracle != null)
				return false;
		} else if (!oracle.equals(other.oracle))
			return false;
		return true;
	}
	
	
	
}