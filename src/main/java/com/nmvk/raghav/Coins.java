package com.nmvk.raghav;

import java.util.Arrays;
import java.util.Scanner;

public class Coins {

	public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        int coins[] = new int[m];
	        for(int coins_i=0; coins_i < m; coins_i++){
	            coins[coins_i] = in.nextInt();
	    }
	        System.out.println(makeChange(coins, n));;

	}

	public static long makeChange(int[] coins, int money) {
       long[] ways = new long[money +1];
       Arrays.sort(coins);
       ways[0] = 1;
       for(int c : coins)
       {
    	   for(int k = c; k <= money;k++)
    	   {
    		   ways[k] += ways[k - c];
    	   }
       }
       
       System.out.println();
       return ways[money];
    } 
}
