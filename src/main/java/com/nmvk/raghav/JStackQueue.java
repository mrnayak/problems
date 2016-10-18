package com.nmvk.raghav;

import java.util.Scanner;

public class JStackQueue {
	java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
	java.util.Stack<Integer> two = new java.util.Stack<Integer>();

	public void enqueue(int x) {

		two.push(x);
		
	}

	public static void main(String[] args) {
		JStackQueue queue = new JStackQueue();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}

	public int dequeue() {
		while (stack.isEmpty() && two.size() > 0) {
			stack.push(two.pop());
		}
		return stack.pop();
	}

	public int peek() {
		while (stack.isEmpty() && two.size() > 0) {
			stack.push(two.pop());
		}
		return stack.peek();
	}

}
