package com.nmvk.raghav.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Graph {
	
	List<Vertex> vertices = new ArrayList<>();
	
	static class Vertex{
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
		public void addEdge(Vertex v)
		{
			edges.add(v);
			v.edges.add(this);
		}
		
		public Vertex nextUndiscoveredEdge()
		{
			for(Vertex v : edges)
			{
				if(!v.discovered)
					return v;
			}
			
			return null;
		}
	}
	
	
	
	
	public void dfs(Vertex v)
	{
		java.util.Stack<Vertex> vstack = new java.util.Stack<>();
		vstack.add(v);
		v.discovered = true;
		System.out.println(v.v + " ");
		while(!vstack.isEmpty())
		{
			Vertex d = vstack.peek();
			
			if(d.nextUndiscoveredEdge() != null)
			{
				Vertex x = d.nextUndiscoveredEdge();
				vstack.push(x);
				x.discovered = true;
				System.out.println(x.v +" ");
			}
			else
				vstack.pop();
		}
	}
	
	public void bfs(Vertex v)
	{
		LinkedList<Vertex> ll = new LinkedList<>();
		ll.add(v);
		v.discovered = true;
		
		while(!ll.isEmpty())
		{
			Vertex z = ll.removeFirst();
			//System.out.println(z.v +" ");
			
			while(z.nextUndiscoveredEdge() != null)
			{
				Vertex c = z.nextUndiscoveredEdge();
				c.discovered = true;
				c.distance = 6 + z.distance;
				ll.add(c);
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g  = new Graph();
		
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		
		while(q >0)
		{
			int n = scan.nextInt();
			for(int i =1; i<= n; i++){
				Vertex v = new Vertex(i);
				g.vertices.add(v);
			}
			
			int m = scan.nextInt();
			
			while(m > 0)
			{
				int u = scan.nextInt();
				int v = scan.nextInt();
				
				g.vertices.get(u-1).edges.add(g.vertices.get(v-1));
				g.vertices.get(v-1).edges.add(g.vertices.get(u-1));
				m--;
			}
			int v1 = scan.nextInt();
			g.bfs(g.vertices.get(v1 - 1));
			
			for(Vertex v : g.vertices)
			{
				if(v.v == v1)
					continue;
				if(v.discovered)
					System.out.print(6+" ");
				else
					System.out.print(-1+" "); 
			}
			System.out.println();
			g = new Graph();
			q--;
		}
		
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		v1.addEdge(v2);
		v1.addEdge(v4);
		v2.addEdge(v3);
		
		g.bfs(v1);
		
	}

}
