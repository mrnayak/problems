package com.nmvk.raghav.dp;

import java.util.Scanner;

public class Fibbo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int a[]= new int[n];
		
		for(int i = 0; i < n; i++)
		{
			a[i] = sc.nextInt();
		}

		
	}

	 public static long getNthfibo(int n) {

	        if (n <= 1) return n;

	        long[][] result = {{1, 0}, {0, 1}}; 
	        long[][] fiboM = {{1, 1}, {1, 0}};

	        while (n > 0) {
	            if (n%2 == 1) {
	                multMatrix(result, fiboM);
	            }
	            
	            n = n / 2;
	            multMatrix(fiboM, fiboM);
	        }

	        return result[1][0];
	    }

	    private static void multMatrix(long[][] m, long [][] n) {
	        long a = m[0][0] * n[0][0] +  m[0][1] * n[1][0];
	        long b = m[0][0] * n[0][1] +  m[0][1] * n[1][1];
	        long c = m[1][0] * n[0][0] +  m[1][1] * n[0][1];
	        long d = m[1][0] * n[0][1] +  m[1][1] * n[1][1];

	        m[0][0] = a;
	        m[0][1] = b;
	        m[1][0] = c;
	        m[1][1] = d;
	    }

}
