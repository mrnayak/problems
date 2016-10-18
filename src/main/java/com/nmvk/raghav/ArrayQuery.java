package com.nmvk.raghav;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuery {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter(System.getProperty("line.separator"));

		String[] line = scan.next().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);

		String[] data = scan.next().split(" ");
		int idata[] = new int[n];
		int z = 0;
		for (String d : data)
			idata[z++] = Integer.parseInt(d);

		while (m > 0) {
			String[] ndata = scan.next().split(" ");
			int i = Integer.parseInt(ndata[1]) - 1;
			int j = Integer.parseInt(ndata[2]) - 1;
			int k = Integer.parseInt(ndata[0]);

			if (k == 1) {
				int[] rdata = new int[n];

				z = 0;

				for (int r = i; r <= j; r++) {
					rdata[z++] = idata[r];
				}
				int v = 0;
				// copy residual
				for (int r = z; r < n; r++) {
					if (v >= i && v <= j) {
						v++; r--;
						continue;
					}
					rdata[r] = idata[v++];
				}
				idata = rdata;
			} else if (k == 2) {
				int[] rdata = new int[n];

				int delta = j -i +1;
				z = n - delta;
				
				for (int r = i; r <= j; r++) {
					rdata[z++] = idata[r];
				}
				int v = 0;
				z = n -delta;
				// copy residual
				for (int r = 0; r < z; r++) {
					if (v >= i && v <= j) {
						v++;r--;
						continue;
					}
					rdata[r] = idata[v++];
				}
				idata = rdata;
			}
			
			m--;
		}
		
		int cal = idata[0] - idata[idata.length - 1];
		if(cal < 0) cal *= -1; 
		System.out.println(cal);
		
		for(int d : idata)
			System.out.print(d + " ");
	}

}
