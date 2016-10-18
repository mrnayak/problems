package com.nmvk.raghav;

import java.util.Scanner;

public class Nikita {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		for (int j = 0; j < k; j++) {
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			
			System.out.println(point(arr, 0, arr.length -1));
		}
	}

	public static int point(int[] arr, int low, int high) {
		if (high <= low)
			return 0;

		long sum = 0;
		for (int i = low; i <= high; i++) {
			sum += arr[i];
		}

		if (sum % 2 != 0)
			return 0;

		int k = low;
		int z = k;
		int temp = 0;
		for (int i = low; i <= high; i++) {
			temp += arr[i];
			if (temp >= sum / 2) {
				break;
			}
			k++;
			z++;

		}
		z --;
		if (temp > sum / 2)
			return 0;

		
		else{
			int a = Math.max(point(arr, low, k), point(arr, k + 1, high));
			return a + 1;
		}
	}

}
