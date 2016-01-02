package com.example.testsingle;

public class TestSynSingle {

	private static TestSynSingle instance = null;

	private TestSynSingle() {

	}

	/**
	 * ����ͬ����
	 * 
	 * @return
	 */
	public static /* synchronized */ TestSynSingle getInstance() {

		/**
		 * ���������飬��һ�ν����ʱ��ȴ�
		 * 
		 * �ڴ��ڶ����ʱ�򲻵ȴ�
		 * 
		 * ˫�ؼ�⣬��߶��Ѵ��ڶ����Ч��
		 */

		if (instance == null) {
			synchronized (TestSynSingle.class) {
				if (instance == null) {
					/**
					 * �Ŵ����ĸ���
					 */
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new TestSynSingle();
				}
			}
		}
		return instance;
	}

	public void print() {
		System.out.println("single dog ");
	}

}

/**
 * ���ܷ�������
 * 
 * @author ���ɵĺ���
 *
 */

class TestSingleclz {

	private static TestSingleclz instance = null;

	private TestSingleclz() {

	}

	public static TestSingleclz getInstance() {
		if (instance == null) {
			/**
			 * �Ŵ���ʵ�ʱ��
			 */
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			instance = new TestSingleclz();
		}
		return instance;
	}

	public void print() {
		System.out.println("single dog ");
	}
}