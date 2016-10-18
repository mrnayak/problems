package com.nmvk.raghav;

import java.util.Scanner;

public class MaxSubarray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		for (int j = 0; j < k; j++) {
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}

			System.out.println(maxSubArray(arr) + " " + maxSubArrayPositive(arr));
		}
	}

	static int maxSubArray(int arr[]) {
		int max = arr[0];
		int sum = 0;
		int maxElem = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum  = Math.max(0, sum +arr[i]);
			max = Math.max(sum,max );
			maxElem = Math.max(maxElem, arr[i]);
		}

		if(max == 0)
			return maxElem;
		return max;
	}

	static int maxSubArrayPositive(int arr[]) {
		int sum = 0;
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= 0)
				sum += arr[i];
				if(arr[i]< min)
					min = arr[i];
		}
		
		if(sum ==0 ) return min;
		return sum;
	}

	private static int maxSubArray(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			int a = maxSubArray(arr, low, mid);
			int b = maxSubArray(arr, mid + 1, high);
			return merge(arr, low, mid, high);
		}
		return 0;
	}

	private static int merge(int arr[], int low, int mid, int high) {
		int lsum = 0;
		int rsum = 0;

		for (int i = low; i <= mid; i++)
			lsum += arr[i];

		for (int i = mid + 1; i <= high; i++)
			rsum += arr[i];
		if (lsum >= 0 && rsum >= 0)
			return lsum + rsum;
		else
			return Math.max(lsum, rsum);
	}

}
