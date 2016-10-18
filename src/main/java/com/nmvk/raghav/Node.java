package com.nmvk.raghav;

class Node {
	int val; // Value
	int ht; // Height
	Node left; // Left child
	Node right; // Right child

	static Node insert(Node root, int val) {
		if (root == null) {
			Node data = new Node();
			data.val = val;
			data.ht = 1;
			return data;

		}

		if (val < root.val) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}

		root.ht = Math.max(root.left == null ? 0 : root.left.ht, root.right == null ? 0 : root.right.ht) + 1;

		int bf = balaceFactor(root);

		if (bf > 1) {
			if (balaceFactor(root.left) < 0) {
				root.left = leftRotate(root.left);
			}

			return rightRotate(root);

		} else if (bf < -1) {
			if (balaceFactor(root.right) > 0) {
				root.right = rightRotate(root.right);
			}

			return leftRotate(root);
		}

		return root;
	}

	static Node rightRotate(Node root) {
		Node t = root.left;
		root.left = t.right;
		t.right = root;
		root.ht = Math.max(root.left == null ? 0 : root.left.ht, root.right == null ? 0 : root.right.ht) + 1;

		t.ht = Math.max(t.left == null ? 0 : t.left.ht, t.right == null ? 0 : t.right.ht) + 1;

		return t;
	}

	static int balaceFactor(Node node) {
		if (node == null || (node.left == null && node.right == null))
			return 0;
		if (node.left == null)
			return -1 * node.right.ht;
		if (node.right == null)
			return node.left.ht;
		return node.left.ht - node.right.ht;
	}

	static Node leftRotate(Node root) {
		Node t = root.right;
		root.right = t.left;
		t.left = root;
		root.ht = Math.max(root.left == null ? 0 : root.left.ht, root.right == null ? 0 : root.right.ht) + 1;

		t.ht = Math.max(t.left == null ? 0 : t.left.ht, t.right == null ? 0 : t.right.ht) + 1;

		return t;
	}
	
	public static void main(String[] args)
	{
		Node s = Node.insert(null, 3);
		Node.insert(s, 2);
		Node.insert(s, 4);
		Node.insert(s, 5);
		Node.insert(s, 6);
		
		System.out.println();
		
	}
}