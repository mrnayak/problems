package com.nmvk.raghav;

import java.util.Scanner;
import java.util.Stack;

public class Operator {
	public static boolean isBalanced(String expression) {
		char[] arr = expression.toCharArray();
		Stack<Character> s = new Stack<>();
		for (char c : arr) {
			switch (c) {
			case ')': if(s.isEmpty()) return false;
				char t = s.pop();
				if (t != '(')
					return false;
				break;

			case '}':if(s.isEmpty()) return false;
				char tx = s.pop();
				if (tx != '{')
					return false;
				break;

			case ']':if(s.isEmpty()) return false;
				char tb = s.pop();
				if (tb != '[')
					return false;
				break;
			case '{' : s.push(c); break;
			case '[' : s.push(c); break;
			case '(' : s.push(c); break;
			}
		}
		return s.isEmpty();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			boolean answer = isBalanced(expression);
			if (answer)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

}
