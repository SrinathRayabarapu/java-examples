package com.dsalgo.trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * given a binary tree, print nodes in zigzag traversal path.
 * <p>
 * 1. two stacks approach
 * idea: Push root to stack1 and based on second row order push left/right children to stack2.
 * pop from stack2 and and repeat the same process to stack1. In this way we can print the order
 * we want.
 * <p>
 * Note: based on print order, root's left/right children push order will change.
 * <p>
 * 2. Using Deque and counter
 * idea: push nodes first or last of the queue based on flip condition and counter
 * <p>
 * 3. Using Deque and null as delimiter
 * idea: use null as delimiter and offer last/first based on delimiter
 * <p>
 * <p>
 * Time complexity : O(n)
 * Space complexity : O(n)
 *
 * @author Srinath.Rayabarapu
 */
public class BTZigZagTraversalMain {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10, "ten");
        root.leftChild = new TreeNode(20, "twenty");
        root.rightChild = new TreeNode(30, "thirty");
        root.leftChild.leftChild = new TreeNode(70, "seventy");
        root.leftChild.rightChild = new TreeNode(60, "sixty");
        root.rightChild.leftChild = new TreeNode(50, "fifty");
        root.rightChild.rightChild = new TreeNode(40, "forty");

        System.out.println("Using Stacks: --------------");
        printZigZagUsingStacks(root);

        System.out.println("Using Queue and Counter: --------------");
        printZigZagUsingDequeCounter(root);

        System.out.println("Using Queue and NULL as delimiter: --------------");
        printZigZagUsingDequeDelimiter(root);

    }

    private static void printZigZagUsingDequeDelimiter(TreeNode root) {

        if (root == null)
            return;

        Deque<TreeNode> queue = new LinkedList<>();

        // delimiter
        queue.offer(null);
        queue.offerFirst(root);

        while (queue.size() > 1) {
            root = queue.peekFirst();
            while (root != null) {
                root = queue.pollFirst();
                System.out.println(root);
                if (root.rightChild != null)
                    queue.offerLast(root.rightChild);
                if (root.leftChild != null)
                    queue.offerLast(root.leftChild);
                root = queue.peekFirst();
            }
            root = queue.peekLast();
            while (root != null) {
                root = queue.pollLast();
                System.out.println(root);
                if (root.leftChild != null)
                    queue.offerFirst(root.leftChild);
                if (root.rightChild != null)
                    queue.offerFirst(root.rightChild);
                root = queue.peekLast();
            }
        }
    }

    /**
     * medium complexity - using one deque with counter
     *
     * @param root
     */
    private static void printZigZagUsingDequeCounter(TreeNode root) {

        if (root == null)
            return;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root);

        int count = 1;
        boolean flip = true;

        while (!queue.isEmpty()) {
            int currentCounter = 0;
            while (count > 0) {
                if (flip) {
                    root = queue.pollFirst();
                    System.out.println(root);
                    if (root.rightChild != null) {
                        queue.offerLast(root.rightChild);
                        currentCounter++;
                    }
                    if (root.leftChild != null) {
                        queue.offerLast(root.leftChild);
                        currentCounter++;
                    }
                } else {
                    root = queue.pollLast();
                    System.out.println(root);
                    if (root.leftChild != null) {
                        queue.offerFirst(root.leftChild);
                        currentCounter++;
                    }
                    if (root.rightChild != null) {
                        queue.offerFirst(root.rightChild);
                        currentCounter++;
                    }
                }
                count--;
            }
            count = currentCounter;
            flip = !flip;
        }

    }

    /**
     * simple approach - but using two stacks
     *
     * @param root
     */
    private static void printZigZagUsingStacks(TreeNode root) {

        if (root == null)
            return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.add(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                System.out.println(root);
                if (root.rightChild != null)
                    stack2.push(root.rightChild);
                if (root.leftChild != null)
                    stack2.push(root.leftChild);
            }
            while (!stack2.isEmpty()) {
                root = stack2.pop();
                System.out.println(root);
                if (root.leftChild != null)
                    stack1.push(root.leftChild);
                if (root.rightChild != null)
                    stack1.push(root.rightChild);
            }
        }

    }

}