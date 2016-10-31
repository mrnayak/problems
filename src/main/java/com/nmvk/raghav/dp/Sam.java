package com.nmvk.raghav.dp;

import java.math.BigInteger;
import java.util.Scanner;

public class Sam {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		char[] cdata = s.toCharArray();
		BigInteger bi = new BigInteger(s);
		
		for(int i = 0; i < cdata.length; i++)
		{
			for(int j = 0; j+i <= cdata.length; j++ )
			{
				String b = s.substring(j, j+i);
				
				if(!"".equalsIgnoreCase(b))
					bi = bi.add(new BigInteger(b));
			}
		}
		BigInteger modulo = BigInteger.TEN;
		modulo = modulo.pow(9);
		modulo = modulo.add(new BigInteger("7"));
		bi = bi.mod(modulo);
		System.out.println(bi);
	}

}
