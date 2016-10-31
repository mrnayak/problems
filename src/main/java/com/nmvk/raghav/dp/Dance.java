package com.nmvk.raghav.dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Dance {
	static String[] routines;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();

		String[] routines = new String[r];
		
		String s = "";
		char c = 'a';
		for(int i = 0; i < r; i++){
			s +=c++;
		}
		
		for(int i = 0; i < r; i++)
		{
			routines[i] = scan.next();
		}

		
	}


public static void permutation(String str) { 
    permutation("", str); 
}

private static void permutation(String prefix, String str) {
    int n = str.length();
    if (n == 0)
    {
    	char[] data = prefix.toCharArray();
    	
    	String previous = routines[data[0] - 'a'];
    	
    	
    }
    else {
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
    }
}

static int countChars(String a, String b)
{
	int qc = 0;
	char[] arr = a.toCharArray();
	for(char c : arr)
	{
		
	}
	
	return qc;
}
}
