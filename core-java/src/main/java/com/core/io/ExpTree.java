package com.core.io;

import java.util.Stack;
import java.util.StringTokenizer;

public class ExpTree {

	private ExpNode root;

	public ExpTree() {
		root = null;
	}

	public ExpTree(String theString) {

		Stack<ExpNode> operatorStack = new Stack<ExpNode>();
		Stack<ExpNode> operandStack = new Stack<ExpNode>();
		StringTokenizer tokenizer = new StringTokenizer(theString, " ()+-/*%",
				true);

		while (tokenizer.hasMoreTokens()) {
			String str = tokenizer.nextToken().trim();
			System.out.println("str " + str);

			if (str.length() == 0) {
			} else if (str.equals("+")) {
				operatorStack.push(new ExpNode(str));
			} else if (str.equals("-")) {
				operatorStack.push(new ExpNode(str));
			} else if (str.equals("/")) {
				operatorStack.push(new ExpNode(str));
			} else if (str.equals("*")) {
				operatorStack.push(new ExpNode(str));
			} else if (str.equals("%")) {
				operatorStack.push(new ExpNode(str));
			} else if (str.equals(")")) {
				/*-	if the token is a ), it should complete an expression.
				So pop the operator stack to get the operator, pop the operand stack to get the lhs and rhs,
				link them all together under the operator node, and push it back onto the operand stack.*/

				ExpNode operand1Removed = operandStack.pop();
				ExpNode operand2Removed = operandStack.pop();

				ExpNode operator1Removed = operatorStack.pop();

				operator1Removed.left = operand2Removed;
				operator1Removed.right = operand1Removed;

				operandStack.push(operator1Removed);

			} else if (str.equals("(")) {
			} else {
				operandStack.push(new ExpNode(str));
			}
		}
		// pops the operand stack one last time to get the full EXP TREE
		ExpNode fullExpTree = operandStack.pop();
		root = fullExpTree;
		printTree();
	}

	// evaluate(): evaluates the expression tree
	public double evaluate() {
		if (root == null) {
			return 0;
		} else
			return evaluateV2(root);
	}

	// evaluateV2: private method that evaluates the tree recursively
	private double evaluateV2(ExpNode subTree) {
		double total = 0;
		double subTreeLeftData;
		double subTreeRightData;
		if (subTree.data.equals("+")) {
			System.out.println("SubTree.data == " + subTree.data);

			if (subTree.left.data.equals("+")) {
				System.out.println("SubTree.left.data == " + subTree.left.data);
				evaluateV2(subTree.left);
			} else if (subTree.left.data.equals("-")) {
				evaluateV2(subTree.left);
			} else if (subTree.left.data.equals("*")) {
				evaluateV2(subTree.left);
			} else if (subTree.left.data.equals("/")) {
				evaluateV2(subTree.left);
			} else if (subTree.right.data.equals("+")) {
				evaluateV2(subTree.right);
			} else if (subTree.right.data.equals("-")) {
				evaluateV2(subTree.right);
			} else if (subTree.right.data.equals("*")) {
				evaluateV2(subTree.right);
			} else if (subTree.right.data.equals("/")) {
				evaluateV2(subTree.right);
			} else {
				subTreeLeftData = Double.parseDouble(subTree.left.data);
				subTreeRightData = Double.parseDouble(subTree.right.data);
				System.out.println("subTreeLeftData: " + subTreeLeftData
						+ " subTreeRightdata: " + subTreeRightData);
				total = subTreeLeftData + subTreeRightData;
				ExpNode newSubTree = new ExpNode(Double.toString(total));
				System.out.println("newSubTree.data == " + newSubTree.data);
				subTree = newSubTree;
				System.out.println("subTree.data == " + subTree.data);
			}
		} else // it's a number
		{
			System.out.println("subTree.data is a number: " + subTree.data);
			total = Double.parseDouble(subTree.data);
			System.out.println("total: " + total);
		}
		return total;
	}

	// printTree methods - prints the tree in RNL order, with indents. Called
	// from "outside"
	public void printTree() {
		if (root == null) {
			System.out.println("The tree is empty");
		} else
			printTree(root, 0); // start with the root with 0 indentations
	}

	// recursive, private version of printTree
	private void printTree(ExpNode subTree, int indents) {
		// if there is a right side, handle it first (with 1 more indent)
		if (subTree.right != null)
			printTree(subTree.right, indents + 1);
		// then print the node itself (first move over the right amount of
		// indents)
		System.out.println("\n\n\n");
		for (int i = 0; i < indents; i++)
			System.out.print("\t");
		System.out.println(subTree);
		// if there is a left side, handle it first (with 1 more indent)
		if (subTree.left != null)
			printTree(subTree.left, indents + 1);
	}

	// toString() - toString method for Exp Tree Uses Print Tree to print the
	// Tree
	public String toString() {
		printTree();
		return "";
	}

	public static void main(String[] args) {

		ExpTree expTree = new ExpTree("(100.29+77.08)*34.98");

		expTree.evaluate();

	}

}

// Class Exp Node: The Nodes for the Exp<b></b>ression Tree
class ExpNode {
	// data
	public String data;
	public ExpNode left;
	public ExpNode right;

	// default constructor
	public ExpNode() {
		data = null;
		left = right = null;
	}

	// constructor
	public ExpNode(String theData) {
		data = theData;
		left = right = null;
	}

	// toString - returns its representation as a String
	public String toString() {
		return "" + data; // or data.toString();
	}
}
