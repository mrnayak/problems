package com.nmvk.raghav;

public class AVL {
	
	private static class AVLNode
	{
		AVLNode left;
		AVLNode right;
		int value;
		int height = 1;
	}
	
	AVLNode root;
	
	public void insert(int value)
	{
		root = insert(root, value);
	}
	
	private AVLNode insert(AVLNode data, int value)
	{
		if(data == null)
		{
			AVLNode n = new AVLNode();
			n.value = value;
			return n;
		}
		
		//Non null case
		if(value < data.value)
		{
			data.left = insert(data.left, value);
		}
		else
		{
			data.right = insert(data.right, value);
		}
		
		//Height
		data.height = Math.max(data.right.height, data.left.height) + 1; 
		int bf = balaceFactor(data);
		
		if(bf > 1)
		{
			//Fix left tree so right rotation it is
			if(balaceFactor(data.left) < 0)
			{
				data.left = leftRotate(data.right);
			}
			
			return rightRotate(data);
		}
		else if(bf < -1)
		{
			//Fix Right tree
			if(balaceFactor(data.left) > 0)
			{
				data.right = rightRotate(data.left);
			}
			
			return rightRotate(data);
		}
		
		return data;
	}
	
	private AVLNode rightRotate(AVLNode node)
	{
		AVLNode temp = node.left;
		node.left = temp.right;
		temp.right = node;
		
		node.height = Math.max(node.left.value, node.right.value) + 1;
		temp.height = Math.max(temp.left.value, temp.right.value) + 1;
		
		return temp;
	}
	
	 
	
	private AVLNode leftRotate(AVLNode node)
	{
		AVLNode temp = node.right;
		node.right = temp.left;
		temp.left = node;
		
		node.height = Math.max(node.left.value, node.right.value) + 1;
		temp.height = Math.max(temp.left.value, temp.right.value) + 1;
		
		return temp;
		
	}
	
	private int balaceFactor(AVLNode node)
	{
		return node.left.height - node.right.height;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
