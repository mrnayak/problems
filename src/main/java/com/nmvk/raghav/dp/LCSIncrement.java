package com.nmvk.raghav.dp;

import java.util.Arrays;
import java.util.Scanner;

public class LCSIncrement {

	public static int LCS(String a, String b) {
		char p[] = a.toCharArray();
		char t[] = b.toCharArray();
		int[][] l = new int[a.length()+1][b.length()+1];
		
		for (int i=0; i<=p.length; i++)
		   {
		     for (int j=0; j<=t.length; j++)
		     {
		       if (i == 0 || j == 0)
		         l[i][j] = 0;
		  
		       else if (p[i-1] == t[j-1])
		         l[i][j] = l[i-1][j-1] + 1;
		  
		       else
		         l[i][j] = Math.max(l[i-1][j], l[i][j-1]);
		     }
		   }
		    
		   return l[a.length()][b.length()];

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter(System.getProperty("line.separator"));
		String first = scan.next();
		char[] x = first.toCharArray();
		Arrays.sort(x);
				
		String second = new String(x).intern();
		System.out.println(second);
		first = first.replaceAll(" ", "");
		
		System.out.println(LCS(first,second));
	}
	
}
