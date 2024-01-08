package com.hackerrank.threeOdaysOfCode;

import java.util.Scanner;

public class Solution_7 {

	public static int getHeight(Node root) {
		
		if (root == null) {
			return -1;
		}
		
		// get recursive depths of left and right
		int ldepth = getHeight(root.left);
		int rdepth = getHeight(root.right);

		// compare between left and right and take the max
		if (ldepth < rdepth) {
			return rdepth+1;
		}
		return ldepth+1;
		
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		Node cur;
		if (data <= root.data) {
			cur = insert(root.left, data);
			root.left = cur;
		} else {
			cur = insert(root.right, data);
			root.right = cur;
		}
		return root;
		
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		int height = getHeight(root);
		System.out.println(height);
	}

}

class Node {
	Node left, right;
	int data;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}