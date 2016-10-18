package com.nmvk.raghav.com.nmvk.raghav;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Airport {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int p[] = new int[n];

		// Delay
		for (int i = 0; i < n; i++) {
			p[i] = scan.nextInt();
		}

		int t[][] = new int[n][n];
		//
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				t[i][j] = scan.nextInt();
			}

		PriorityQueue<Event> eList = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			Event e = new Event(scan.nextInt(), scan.nextInt(), scan.nextInt());
			eList.add(e);
		}
		
		scan.close();
		int maxFlights = 0;
		int flights = 0;
		while(!eList.isEmpty())
		{
			Event e = eList.poll();
			if(!e.isEnd)
			{
				int endTime = t[e.source - 1][e.destination -1] + p[e.destination -1];
				e.startTime += endTime;
				e.isEnd = true;
				eList.add(e);
				flights++; 
			}
			else
			{
				flights--;
			}
			
			if(flights > maxFlights)
				maxFlights = flights;
		}
		
		System.out.println(maxFlights);
		
		
	}

	static class Event implements  Comparable<Event> {
		int startTime;
		int source;
		int destination;
		boolean isEnd = false;
		
		public Event( int source, int destination, int startTime) {
			super();
			this.startTime = startTime;
			this.source = source;
			this.destination = destination;
		}


		@Override
		public int compareTo(Event o) {
			// TODO Auto-generated method stub
			int r =  this.startTime - o.startTime;
			
			if(r == 0 && o.isEnd)
				return 1;
			else if (r == 0 && this.isEnd)
				return -1;
						
			return r;
		}

		
	}
}
