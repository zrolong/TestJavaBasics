package com.example.testsynchronized;

/**
 * ͬ����{
 * 
 * }
 * 
 * ͬ������
 * 
 * @author ���ɵĺ���
 *
 */
public class Test {

	public static void main(String[] args) {

		MyThread target = new MyThread();

		Thread t1 = new Thread(target);
		Thread t2 = new Thread(target);
		Thread t3 = new Thread(target);
		Thread t4 = new Thread(target);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}

class MyThread implements Runnable {

	private int num = 50;
	boolean flag = true;

	@Override
	public void run() {
		while (true) {
			//test();
			testSynchronized();
		}

	}

	private void testSynchronized() {
		synchronized(this){
		if (num <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "  " + num--);
		}
	}

	@SuppressWarnings("unused")
	private synchronized void test() {

		if (num <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "  " + num--);

	}
}