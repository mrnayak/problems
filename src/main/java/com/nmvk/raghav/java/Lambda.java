package com.nmvk.raghav.java;

import java.util.function.Function;

public class Lambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Util<String> rs = (String s) -> {
			String k = "";
			for (int i = s.length() - 1; i >= 0; i--)
				k = k + s.charAt(i);
			System.out.println(k);
		};

		rs.rev("Yo Yoo");

		Util<Integer> is = (Integer r) -> {
			long x = 0;
			while (r != 0) {
				x = x * 10 + r % 10;
				r = r / 10;
			}

			System.out.println(x);
		};

		System.out.println(reverse(1534236469));

	}

	public static int reverse(int r) {
		long x = 0;
		while (r != 0) {
			x = x * 10 + r % 10;
			r = r / 10;
		}
		if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
			return 0;
		return (int)x;
	}

	interface Util<T> {
		void rev(T s);
	}

}
