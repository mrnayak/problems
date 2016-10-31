package com.nmvk.raghav.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hyper {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int n = scan.nextInt();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < t; i++) {
			String s = scan.next();
			
			int slen = s.length();
			int square = 0;
			for(int k = 0; k < slen;k++)
			for(int j = 0; j<slen;j++)
			{
				if(slen % 2 == 0) 
				{
					square+= 1;
				}
			}
		}
		
		
	}
	
	static int square(String s)
	{
		
		int slen = s.length();
		if(slen< 2) return 0;
		if(s.substring(0, slen/2).equals(s.substring(slen/2)))
		{
			return 1;
		}
		
		return 0;
	}

}
