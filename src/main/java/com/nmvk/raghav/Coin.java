package com.nmvk.raghav;

import java.util.Scanner;

public class Coin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] denom = new int[m];

		for (int i = 0; i < m; i++) {
			denom[i] = scan.nextInt();
		}
	}

	static int ways(int n, int denom[]) {
		int data[] = new int[n + 1];

		for (int i = 1; i <= n; i++)
			for (int j = 0; j < denom.length; j++) {
				
			}

		return -1;
	}
}
