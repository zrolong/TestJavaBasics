package com.example.testarray;

import java.util.Arrays;

public class TestArray2 {
	
	public static void TestMatrix() {
		int[][] a = { { 1, 3 }, { 2, 4 } };
		int[][] b = { { 3, 4 }, { 5, 6 } };
		int[][] c = new int[2][2];

			
		for (int i = 0; i < 2; i ++) {
			for(int j = 0; j < 2;j ++){
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		
		for (int i = 0; i < 2; i ++) {
			for(int j = 0; j < 2;j ++){
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}
		
		int[] d = { 1,2,3,4,10,5,6,7,8,9 };
		Arrays.sort(d);
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.binarySearch(d, 10));


	}
	
	@SuppressWarnings("unused")
	public static void testArray(){
		

		// ��ά���龲̬��ʼ��
		int[][] a = { { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 } };

		/**
		 * �����ȶ���һά
		 */
		int[][] b = new int[3][];
		
	}

	public static void main(String[] args) {
		//testArray();
		TestMatrix();
				
	}

}