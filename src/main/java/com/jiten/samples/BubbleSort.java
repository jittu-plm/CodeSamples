package com.jiten.samples;

public class BubbleSort {
	/**
	 * bubble sort
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] {5, 1, 4, 2, 8};
		rBubblesort(a,a.length-1);
		
		printArray(a);

	}
	
	
	private static void printArray(int[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}


	private static void rBubblesort(int a[], int n) {
		int temp = 0;
		if(n == 1)
			return;
		for (int i = 0; i < n-1; i++) {
			if(a[i] > a[i+1])
			{
				temp = a[i];
				a[i] = a[i+1];
				a[i+1] = temp;
			}
		}
		rBubblesort(a, n-1);
	}
}
