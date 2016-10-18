package com.nmvk.raghav.test;

import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Duper {

	// result of applying binary operator op to two operands val1 and val2
	public static double eval(String op, double val1, double val2) {
		if (op.equals("+"))
			return val1 + val2;
		if (op.equals("-"))
			return val1 - val2;
		if (op.equals("/"))
			return val1 / val2;
		if (op.equals("*"))
			return val1 * val2;
		throw new RuntimeException("Invalid operator");
	}

	public static void main(String[] args) {

		// precedence order of operators
		TreeMap<String, Integer> precedence = new TreeMap<String, Integer>();
		precedence.put("(", 0); // for convenience with algorithm
		precedence.put(")", 0);
		precedence.put("+", 1); // + and - have lower precedence than * and /
		precedence.put("-", 1);
		precedence.put("*", 2);
		precedence.put("/", 2);

		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(System.getProperty("line.separator"));
		String[] sd = sc.next().split(" ");

		for (String s : sd) {

			// read in next token (operator or value)

			// token is a value
			if (!precedence.containsKey(s)) {
				vals.push(Double.parseDouble(s));
				continue;
			}

			// token is an operator
			while (true) {

				// the last condition ensures that the operator with higher
				// precedence is evaluated first
				if (ops.isEmpty() || s.equals("(") || (precedence.get(s) > precedence.get(ops.peek()))) {
					ops.push(s);
					break;
				}

				// evaluate expression
				String op = ops.pop();

				// but ignore left parentheses
				if (op.equals("(")) {
					assert s.equals(")");
					break;
				}

				// evaluate operator and two operands and push result onto value
				// stack
				else {
					double val2 = vals.pop();
					double val1 = vals.pop();
					vals.push(eval(op, val1, val2));
				}
			}
		}

		// finished parsing string - evaluate operator and operands remaining on
		// two stacks
		while (!ops.isEmpty()) {
			String op = ops.pop();
			double val2 = vals.pop();
			double val1 = vals.pop();
			vals.push(eval(op, val1, val2));
		}

		// last value on stack is value of expression
		System.out.println(vals.pop());
		assert vals.isEmpty();
		assert ops.isEmpty();
	}
}