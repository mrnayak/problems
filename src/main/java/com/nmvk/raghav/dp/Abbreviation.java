package com.nmvk.raghav.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Abbreviation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();

		int l = 0;
		int k=0;
		for(int i = 1; i <= q;i++)
		{
			k = 1;
			while (k < q)
			{
				k *= 2;
				l++; 
			}
		}
		
		System.out.println(k);
		System.out.println(l);

	}
	
	

}
