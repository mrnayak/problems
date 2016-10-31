package com.nmvk.raghav.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kruskal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List<Vertex> vList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Vertex v = new Vertex();
			v.v = i + 1;

			vList.add(v);
		}
		int e = scan.nextInt();

		PriorityQueue<Edge> edges = new PriorityQueue<>();
		for (int i = 0; i < e; i++) {
			Edge edge = new Edge();
			edge.v1 = scan.nextInt();
			edge.v2 = scan.nextInt();
			edge.weight = scan.nextLong();

			vList.get(edge.v1 - 1).edges.add(edge);
			vList.get(edge.v2 - 1).edges.add(edge);
		}
		int s = scan.nextInt();

		HashSet<Integer> vertex = new HashSet<>();
		Long sum = 0L;

		// Initialize
		edges.addAll(vList.get(s - 1).edges);

		while (!edges.isEmpty() && vertex.size() <= n) {
			Edge ed = edges.poll();
			if (vertex.contains(ed.v1) && vertex.contains(ed.v2)) {
				continue;
			}

			if (vertex.add(ed.v1))
				edges.addAll(vList.get(ed.v1 - 1).edges);
			if (vertex.add(ed.v2))
				edges.addAll(vList.get(ed.v2 - 1).edges);
			sum += ed.weight;

		}

		System.out.println(sum);
	}

	static class Edge implements Comparator<Edge>, Comparable<Edge> {
		int v1;
		int v2;
		Long weight;

		@Override
		public int compare(Edge o1, Edge o2) {
			int rv = Long.compare(o1.weight, o2.weight);
			if (rv == 0) {
				rv = Long.compare(o1.v1 + o1.v2 + o1.weight, o2.v1 + o2.v2 + o2.weight);
			}

			return rv;
		}

		@Override
		public int compareTo(Edge o) {
			return compare(this, o);
		}
	}

	static class Vertex {
		int v;
		List<Edge> edges = new ArrayList<>();
	}
}
