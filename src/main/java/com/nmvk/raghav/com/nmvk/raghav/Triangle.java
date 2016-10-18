package com.nmvk.raghav.com.nmvk.raghav;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> t1 = new ArrayList<>();

		for (int i = 0; i < 3; i++)
			t1.add(scan.nextInt());

		for (int i = 0; i < 3; i++) {
			int x = scan.nextInt();
			if (!t1.contains(x))
				t1.add(x);
		}
		
		scan.close();
		
		if (t1.size() != 3){
			System.out.println("NO");
			System.exit(0);
		}
		Collections.sort(t1);

		double hypotenus = Math.pow(t1.get(2), 2);
		double oppside = Math.pow(t1.get(0), 2);
		double adjside = Math.pow(t1.get(1), 2);

		if (hypotenus == (oppside + adjside))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
