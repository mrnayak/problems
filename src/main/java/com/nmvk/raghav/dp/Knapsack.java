package com.nmvk.raghav.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		Map<Integer, Integer> data = new HashMap<Integer, Integer>();
		for (int i = 0; i < t; i++) {
			int val = scan.nextInt();
			int capacity = scan.nextInt();
			int[] weights = new int[val];
			for (int j = 0; j < val; j++) {
				weights[j] = scan.nextInt();
			}

			Arrays.sort(weights);

			System.out.println(capacity - knapDP(capacity, weights));

		}
	}

	static Integer knap(int capacity, int weights[]) {
		if (capacity <= 0)
			return 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int weigh : weights) {
			if (capacity >= weigh)
				pq.add(knap(capacity - weigh, weights));
			else
				pq.add(capacity);
		}

		return pq.peek();
	}
	
	static Integer knapDP(int capacity, int weights[])
	{
		int data[] = new int[capacity+1];
		
		for(int i = 0; i < capacity + 1 ; i++)
			data[i] = capacity;
		
		for(int i =1;i<=capacity;i++)
		for(int j = 0;j<weights.length;j++)
		{
			if(weights[j] > i)
				continue;
			data[i] = Math.min(i - weights[j], data[i]);
			data[i] = Math.min( data[i - weights[j]], data[i]);
		}
		
		return data[capacity];
	}
}
