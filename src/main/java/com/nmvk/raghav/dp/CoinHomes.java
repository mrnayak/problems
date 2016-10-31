package com.nmvk.raghav.dp;

import java.util.Arrays;
import java.util.Scanner;

public class CoinHomes {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();
		int t = scan.nextInt();
		int[] coins = new int[t];
		for (int i = 0; i < t; i++) {
			coins[i] = scan.nextInt();
		}

		System.out.println(coins(coins, value));
	}

	static int coins(int[] coins, int value) {

		int data[] = new int[value + 1];

		for (int i = 1; i <= value; i++)
			data[i] = i;
		
		for (int i = 1; i <= value; i++){
			for (int j = 0; j < coins.length; j++) {

				if (i < coins[j])
					continue;

				int val = i % coins[j];
				if (val == 0)
					val = i / coins[j];
				else {
					val = i / coins[j] + data[val];
				}

				data[i] = Math.min(val, data[i]);
			}
			
			System.out.println(Arrays.toString(data));
		}
		
		return data[value];
	}
}
