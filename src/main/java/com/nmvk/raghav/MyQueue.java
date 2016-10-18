package com.nmvk.raghav;

import java.util.Scanner;

public class MyQueue {
	Stack stack = new Stack();
	Stack two = new Stack();

	public void enqueue(int x) {
		Node z = stack.pop();
		while (z != null) {
			two.insert(z.data);
			z = stack.pop();
		}

		two.insert(x);
		z = two.pop();
		while (z != null) {
			stack.insert(z.data);
			z = two.pop();
		}
	}
	public static void main(String[] args) {
        MyQueue queue = new MyQueue();

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
		return stack.pop().data;
	}
	
	public int peek()
	{
		return stack.peek().data;
	}

	static class Node {
		Node next;
		int data;
	}

	static class Stack {
		Node top;

		public void insert(int data) {
			Node n = new Node();
			n.data = data;

			n.next = top;
			top = n;
		}

		public Node pop() {
			if (top != null) {
				Node t = top;
				top = top.next;
				return t;
			}
			return null;
		}
		
		public Node peek()
		{
			return top;
		}
	}
}