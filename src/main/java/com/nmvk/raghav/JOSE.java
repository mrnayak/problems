package com.nmvk.raghav;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JOSE {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		PriorityQueue<Event> priorityQueue = new PriorityQueue<>();
		List<Event> arrivalList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Event ee = new Event(scan.nextInt(), scan.nextInt());
			arrivalList.add(ee);
		}

		int clk = 0;

		while (priorityQueue.size() > 0 || arrivalList.size() > 0) {
			
			while (m > 0 && arrivalList.size() > 0) {
				Event x = arrivalList.get(0);
				if (x.memory <= m) {
					arrivalList.remove(0);
					x.clock += clk;
					x.type = "Completion";
					priorityQueue.add(x);
					m -= x.memory;
				}
				else
					break;
			}

			if (priorityQueue.size() > 0) {
				Event ee = priorityQueue.poll();
				if (ee.type.equalsIgnoreCase("Completion")) {
					m += ee.memory;
					clk = ee.clock;
				}
			}
		}
		
		System.out.println(clk);

	}

	static class Event implements Comparator<Event>, Comparable<Event> {
		int clock;
		int memory;
		String type = "Arrival";

		public Event(int n, int m) {
			this.clock = n;
			this.memory = m;
		}

		@Override
		public int compare(Event arg0, Event arg1) {
			return arg0.clock - arg1.clock;
		}

		@Override
		public int compareTo(Event o) {
			return this.clock - o.clock;
		}

	}
}
