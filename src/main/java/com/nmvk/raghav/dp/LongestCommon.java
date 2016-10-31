package com.nmvk.raghav.dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class LongestCommon {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = in.nextInt();
		}

		System.out.println(longestLength(data));
	}

	static int longestLength(int[] s) {
		int maxLength = 1;
		int l[] = new int[s.length];
		int parent[] =new int[s.length];
		l[0] = 1;
		
		for(int i = 0; i < parent.length; i++)
			parent[i] = i;
		int maxLengthIndex = 0;
		for (int i = 1; i < s.length; i++)
		{
		   l[i] = 1;
		   for (int j = i - 1; j >= 0; j--)
		      if (l[j] + 1 > l[i] && s[j] <= s[i])
		      {
		         l[i] = l[j] + 1;
		         parent[i] = j;
		      }

		   if (l[i] > maxLength)
		   {
		      maxLength = l[i];
		      maxLengthIndex = i;
		   }
		}
		
		printLIS(s, parent, maxLengthIndex);
		System.out.println();
		return maxLength;
	}

	public static void printLIS(int[] s,int parent[], int maxLengthIndex)
	{
		
		if(parent[maxLengthIndex] != maxLengthIndex)
		{
			printLIS(s, parent, parent[maxLengthIndex]);
			System.out.println(s[maxLengthIndex]);
		}
		else
			System.out.println(s[maxLengthIndex]);
		
	}
}
