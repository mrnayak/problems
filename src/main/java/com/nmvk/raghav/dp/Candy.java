package com.nmvk.raghav.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Candy {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		int rating[] = new int[q+1];
		for (int k = 0; k < q; k = k + 1) {
			rating[k] = scan.nextInt();
		}

		int[] candies = new int[q];
		candies[0] = 1;
		for(int j = 1; j < q; j++)
		{
			if(rating[j] >  rating[j-1])
			{
				candies[j] = candies[j-1] +1;
			}
			else
				candies[j] = 1;
		}
		
		for(int j = q-2; j >=0; j--)
		{
			if(rating[j] >  rating[j+1])
			{
				candies[j] = Math.max(candies[j+1] +1, candies[j]);
			}
			
		}
		int sum = 0;
		for(int c : candies)
			sum+=c;
		System.out.println(sum);

	}

}
