package com.nmvk.raghav.bits;

import java.util.Scanner;

public class SumXOR {

	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        long n = in.nextLong();
	        long sum = 64 - Long.numberOfLeadingZeros(n) - Long.bitCount(n);
	        System.out.println(Math.round(Math.pow(2, sum)));
	       }
	        

}
