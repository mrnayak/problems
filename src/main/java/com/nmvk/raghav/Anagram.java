package com.nmvk.raghav;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Anagram {
	public static int numberNeeded(String first, String second) {
		char[] f = first.toCharArray();
		char[] s = second.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		for (char o : f) {
			if (map.containsKey(o)) {
				map.put(o, map.get(o) + 1);
			}

			else
				map.put(o, 1);
		}

		for (char o : s) {

			if (map2.containsKey(o)) {
				map2.put(o, map2.get(o) + 1);
			}

			else
				map2.put(o, 1);
		}
		
		
		int count = 0;
		for (Character c : map.keySet()) {
			if (map2.get(c) == null)
				count += map.get(c);
			else
			{
				count += Math.max(map.get(c), map2.get(c)) - Math.min(map.get(c), map2.get(c));
			}
		}
		
		for (Character c : map2.keySet())
			{
			if (map.get(c) == null)
				count += map2.get(c);
			}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
}
