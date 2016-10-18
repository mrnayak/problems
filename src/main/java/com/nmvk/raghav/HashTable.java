package com.nmvk.raghav;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTable {

	Map<String, Integer> magazineMap;// = new HashMap<>();
	String[] notes;

	public HashTable(String magazine, String note) {
		magazineMap = new HashMap<>();
		String[] mag = magazine.split(" ");
		this.notes = note.split(" ");

		for (String m : mag) {
			Integer x = magazineMap.get(m);

			if (x != null &&  x != 1)
				magazineMap.put(m, ++x);
			else
				x = magazineMap.put(m, 1);
		}

	}

	public boolean solve() {
		for (String n : notes) {
			Integer x = magazineMap.get(n);
			if (x == null || x < 1)
				return false;
			magazineMap.put(n, --x);
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		// Eat whitespace to beginning of next line
		scanner.nextLine();

		HashTable s = new HashTable(scanner.nextLine(), scanner.nextLine());
		scanner.close();

		boolean answer = s.solve();
		if (answer)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
