package com.nmvk.raghav;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trie {
	TrieNode root = new TrieNode();
	
	public Trie(){root.familySize = 0;}
	
	public void insert(String n)
	{
		TrieNode node = root;
		for(int i =0; i < n.length(); i++)
		{
			if(node.children.get(n.charAt(i)) != null)
			{
				node = node.children.get(n.charAt(i));
				node.familySize = node.familySize +1;
			}
			else
			{
				TrieNode t = new TrieNode();
				t.c = n.charAt(i);
				node.children.put(t.c, t);
				node = t;
			}
			
			if(i == n.length() - 1)
				node.isLeaf = true;
		}
	}
	
	public int search(String s)
	{
		TrieNode node = root;
		char[] data = s.toCharArray();
		
		for(int i =0; i < data.length; i++)
		{
			if(node.children.get(data[i]) == null)
				return 0;
			node = node.children.get(data[i]);
		}
		
		//System.out.println(node.c);
		
		return node.familySize;
	}

	public static class TrieNode
	{
		char c;
		boolean isLeaf;
		int familySize = 1;
		Map<Character, TrieNode> children = new HashMap<>();
	}
	public static void main(String[] args) {
		Trie t = new Trie();
		
	   Scanner scan = new Scanner(System.in);
	   scan.useDelimiter(System.getProperty("line.separator"));
	   
	   int n = scan.nextInt();
	   
	   for(int i = 0; i < n;i++ )
	   {
		   String[] line = scan.next().split(" ");
		   if(line[0].equals("add") )
			   t.insert(line[1]);
		   else
			   System.out.println(t.search(line[1]));
	   }
	   
		
	}
}
