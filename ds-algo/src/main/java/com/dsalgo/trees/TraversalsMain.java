package com.dsalgo.trees;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * On a given binary search tree(BST) -
  
   				40
   		20				60
   	10		30		50		70
   
 * 1. In Order traversal - left, root, right
	Traverse the left subtree in InOrder.
	Visit the node.
	Traverse the right subtree in InOrder.

	10 20 30 40 50 60 70


 * 2. Pre Order traversal - root, left, right
 	Visit the node.
	Traverse the left subtree in PreOrder.
	Traverse the right subtree in PreOrder.
	
	40 20 10 30 60 50 70 


 * 3. Post Order traversal - left, right, root
	Traverse the left subtree in PostOrder.
	Traverse the right subtree in PostOrder.
	Visit the node.
	
	10 30 20 50 70 60 40 
	
 *
	
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class TraversalsMain {

	public static void main(String[] args) {

		TreeNode root = TreeUtil.create6NodesTree();

		log.info("Original Tree: ");
		log.info("           60            ");
		log.info("     30            80    ");
		log.info("10      50     70        90");


		log.info("----- In Order -----");
		inOrderRecursive(root);

		log.info("----- Pre Order -----");
		preOrderRecursive(root);

		log.info("----- Post Order -----");
		postOrderRecursive(root);

	}

	/**
	 * left, node, right
	 *
	 * recursion uses implicit(thread) stack
	 *
	 * TC: O(n)
	 * SC: O(h) where h is the height of the tree
	 *
	 * @param node
	 */
	private static void inOrderRecursive(TreeNode node) {
		if(node != null){
			inOrderRecursive(node.leftChild);
			print(node);
			inOrderRecursive(node.rightChild);
		}
	}

	/**
	 * node, left, right
	 *
	 * @param node
	 */
	private static void preOrderRecursive(TreeNode node) {
		if(node != null){
			print(node);
			preOrderRecursive(node.leftChild);
			preOrderRecursive(node.rightChild);
		}
	}

	/**
	 * left, right, node
	 *
	 * @param node
	 */
	private static void postOrderRecursive(TreeNode node){
		if(node != null){
			postOrderRecursive(node.leftChild);
			postOrderRecursive(node.rightChild);
			print(node);
		}
	}

	/**
	 * Need to do manual - uses external Stack
	 *
	 * Create empty stack and push root node to it.
	 * Do the following when stack is not empty
	 * Pop a node from stack and print it
	 * Push right child of popped node to stack
	 * Push left child of popped node to stack
	 *
	 * @param node
	 */
	private static void preOrderIterative(TreeNode node) {
		
		if(node == null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(node);
		
		while(!stack.empty()){
			TreeNode pop = stack.pop();
			print(pop);
			
			//push right first so that while popping left comes early
			if(pop.rightChild != null)
				stack.push(pop.rightChild);

			if(pop.leftChild != null)
				stack.push(pop.leftChild);
		}
	}

	static void inOrderIterative(Node root){
		Stack<Node> stack = new Stack<>();

		Node current = root;

		while (current != null || !stack.isEmpty()){

			while (current != null){
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			System.out.print(current.value +" ");
			current = current.right;
		}
	}

	private static void postOrderIterative(Node root) {
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();

		stack1.push(root);

		while (!stack1.empty()){
			Node node = stack1.pop();
			stack2.push(node);

			if (node.left != null){
				stack1.push(node.left);
			}

			if (node.right != null){
				stack1.push(node.right);
			}
		}

		while (!stack2.empty()){
			System.out.print(stack2.pop().value + " ");
		}

	}

	private static void print(TreeNode tNode) {
		log.info(tNode.data +" ");
	}
}