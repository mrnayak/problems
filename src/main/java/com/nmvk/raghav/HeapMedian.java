package com.nmvk.raghav;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Hashtable;;
public class HeapMedian {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];

		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		for (int a_i = 0; a_i < n; a_i++) {
			Integer m = min.poll();
			if (m != null)
				max.add(m);
			
			max.add(in.nextInt());

			while (min.size()+1 < max.size()) {
				min.add(max.poll());
			}

			if (min.size() == max.size()) {
				double d = min.peek() + max.peek();
				System.out.println(d / 2);
			} else
				System.out.println((double) max.peek());
			
		}

	}

}
