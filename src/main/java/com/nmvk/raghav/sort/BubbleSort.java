package com.nmvk.raghav.sort;

import java.util.Scanner;

public class BubbleSort {

	public static int sort(int[] a)
	{
		int numberOfSwaps = 0;
		for(int i = 0; i< a.length; i++)
		{
			for(int j = 0; j < a.length -1; j++)
			{
				if(a[j] >  a[j+1])
				{
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
					numberOfSwaps++;
				}
			}
			if (numberOfSwaps == 0) {
		        break;
		    }
		}
		
		return numberOfSwaps;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scan.nextInt();

		int e = sort(arr);

		System.out.println("Array is sorted in " + e + " swaps.");
		System.out.println("First Element: " + arr[0]);
		System.out.println("Last Element: "+arr[arr.length - 1]);

	}

}
