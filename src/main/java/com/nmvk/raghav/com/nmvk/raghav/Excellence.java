package com.nmvk.raghav.com.nmvk.raghav;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Excellence {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int data[] = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			data[i] = scan.nextInt();
		}
		
		//Sort
		Arrays.sort(data);
		
		PriorityQueue<Integer> teamRank = new PriorityQueue<>();
		
		int i = 0;
		int mid = data.length /2;
		int j = data.length - 1;
		
		while(i < mid && j >= mid)
		{
			teamRank.add(data[i] + data[j]);
			i++;
			j--;
		}
		
		System.out.println(teamRank.peek());
	}

}
