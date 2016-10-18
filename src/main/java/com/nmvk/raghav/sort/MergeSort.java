package com.nmvk.raghav.sort;

import java.util.Scanner;

public class MergeSort {

	int num[];
	int helper[];
	int swap = 0;

	public MergeSort(int n[]) {
		this.num = n;
		this.helper = new int[num.length];
	}

	public int sort() {
		mergeSort(0, num.length - 1);
		return swap;
	}

	private void mergeSort(int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			merge(low, mid, high);
		}
	}

	public void merge(int low, int mid, int high) {
		for (int k = low; k <= high; k++)
			helper[k] = num[k];

		int i = low;
		int j = mid + 1;
		int p = low;

		while (i <= mid && j <= high) {
			if (helper[j] < helper[i]) {
				num[p++] = helper[j];
				j++;
				swap += mid + 1 - i;
			} else if (helper[i] <= helper[j]) {
				num[p++] = helper[i];
				i++;
			}
		}
		
		while (i <= mid) {
			num[p++] = helper[i++];
		}
	}

	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			MergeSort ms = new MergeSort(arr);
			System.out.println(ms.sort());
		}
	}

}
