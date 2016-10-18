package com.nmvk.raghav.com.nmvk.raghav;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Classy {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter(System.getProperty("line.separator"));
		int n = scan.nextInt();
		Map<String, Character> classMap = new HashMap<>();
		classMap.put("lower", 'c');
		classMap.put("middle", 'b');
		classMap.put("upper", 'a');
		List<Person> pList = new ArrayList<>();
		int max = 0;

		for (int i = 0; i < n; i++) {
			String name = scan.next();

			String d = "";
			String temp = "";
			String[] keys = name.split(" ");
			for (int k = 1; k < keys.length; k++) {
				temp = keys[k];
				if (temp.equalsIgnoreCase("class"))
					break;
				d = classMap.get(temp) + d;
			}
			if (d.length() > max)
				max = d.length();
			Person p = new Person();
			p.name = keys[0].replace(":", "");
			p.hash = d;
			pList.add(p);
		}

		for (Person p : pList) {
			while (p.hash.length() < max) {
				p.hash += "b";
			}
		}

		Collections.sort(pList);
		for (Person p : pList) {
			System.out.println(p.name);
		}

		scan.close();
	}

	static class Person implements Comparator<Person>, Comparable<Person> {
		String name;
		String hash;

		@Override
		public int compare(Person o1, Person o2) {
			int r = o1.hash.compareTo(o2.hash);

			if (r == 0)
				return o1.name.compareTo(o2.name);
			return r;

		}

		@Override
		public int compareTo(Person o) {
			int r = this.hash.compareTo(o.hash);

			if (r == 0)
				return this.name.compareTo(o.name);
			return r;
		}

	}
}
