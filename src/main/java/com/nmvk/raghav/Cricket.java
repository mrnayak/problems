package com.nmvk.raghav;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cricket {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i <n;i++)
			map.put(in.nextInt(), in.nextInt());
		
		
		

	}

}
