package com.nmvk.raghav.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Delivery {

	List<Vertex> vertices = new ArrayList<>();

	static class Vertex {
		int v;
		Set<Vertex> edges = new HashSet<>();
		boolean discovered = false;
		int distance = 0;

		public Vertex(int i) {
			this.v = i;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + v;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vertex other = (Vertex) obj;
			if (v != other.v)
				return false;
			return true;
		}

		public void addEdge(Vertex v) {
			if (v == null)
				return;
			edges.add(v);
			v.edges.add(this);
		}

		public Vertex nextUndiscoveredEdge() {
			for (Vertex v : edges) {
				if (!v.discovered)
					return v;
			}

			return null;
		}
	}

	public void dfs(Vertex v) {
		java.util.Stack<Vertex> vstack = new java.util.Stack<>();
		vstack.add(v);
		v.discovered = true;
		System.out.println(v.v + " ");
		while (!vstack.isEmpty()) {
			Vertex d = vstack.peek();

			if (d.nextUndiscoveredEdge() != null) {
				Vertex x = d.nextUndiscoveredEdge();
				vstack.push(x);
				x.discovered = true;
				System.out.println(x.v + " ");
			} else
				vstack.pop();
		}
	}

	public void bfs(Vertex v) {
		LinkedList<Vertex> ll = new LinkedList<>();
		ll.add(v);
		v.discovered = true;

		while (!ll.isEmpty()) {
			Vertex z = ll.removeFirst();
			// System.out.println(z.v +" ");

			while (z.nextUndiscoveredEdge() != null) {
				Vertex c = z.nextUndiscoveredEdge();
				c.discovered = true;
				c.distance = 1 + z.distance;
				ll.add(c);
			}
		}
	}

	public static void main(String[] args) {
		Delivery g = new Delivery();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 1; i <= n; i++) {
			Vertex v = new Vertex(i);
			g.vertices.add(v);
		}

		int m = scan.nextInt();
		int q = scan.nextInt();

		for (int i = 0; i*2 < n;i++) {
			System.out.println(i);
			Vertex v = g.vertices.get(i);
			Vertex lchild = g.vertices.get(g.vertices.indexOf(new Vertex(v.v * 2)));
			Vertex rchild = g.vertices.get(g.vertices.indexOf(new Vertex(v.v * 2 + 1)));

			v.addEdge(lchild);
			v.addEdge(rchild);
		}

		Map<Vertex, Set<Vertex>> foodMap = new HashMap<>();

		for (int i = 0; i < m; i++) {
			String[] fType = scan.next().split(" ");

			int foodtype = Integer.parseInt(fType[0]);
			Set<Vertex> fj = new HashSet<>();

			for (int k = 1; k < fType.length; k++)
				fj.add(g.vertices.get(g.vertices.indexOf(new Vertex(Integer.parseInt(fType[k])))));
			
			foodMap.put(g.vertices.get(g.vertices.indexOf(new Vertex(foodtype))), fj);
		}

		Set<int[]> req = new HashSet<>();
		for (int i = 0; i < q; i++) {
			int food = scan.nextInt();
			int person = scan.nextInt();

			int[] data = { food, person };
			req.add(data);
		}

		 g.bfs(g.vertices.get(g.vertices.indexOf(new Vertex(1))));

	}

}
