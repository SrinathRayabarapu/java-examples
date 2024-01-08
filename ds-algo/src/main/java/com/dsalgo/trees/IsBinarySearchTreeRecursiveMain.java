package com.dsalgo.trees;

/**
 * Given a binary tree, return true if it is binary search tree else return false.<br>
 * <p>
 * Solution -
 * Keep min, max for every recursion. Initial min and max is very small and very larger number.
 * Check if root.data is in this range. When you go left pass min and root.data and for right pass
 * root.data and max.
 * <p>
 * Time complexity is O(n) since we are looking at all nodes.
 *
 * <pre>
 * Test cases:
 * Null tree
 * 1 or 2 nodes tree
 * Binary tree which is actually BST
 * Binary tree which is not a BST
 * </pre>
 * <p>
 * https://youtu.be/MILxfAbIhrE
 * https://www.quora.com/What-is-the-difference-between-a-binary-tree-and-a-binary-search-tree
 *
 * @author Srinath.Rayabarapu
 */
public class IsBinarySearchTreeRecursiveMain {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10, "ten");
        root.leftChild = new TreeNode(20, "twenty");
        root.rightChild = new TreeNode(30, "thirty");
        root.leftChild.leftChild = new TreeNode(70, "seventy");
        root.leftChild.rightChild = new TreeNode(60, "sixty");
        root.rightChild.leftChild = new TreeNode(50, "fifty");
        root.rightChild.rightChild = new TreeNode(40, "forty");

        boolean isBST = isBST(root);
        System.out.println(isBST);

        root = new TreeNode(40, "forty");
        root.leftChild = new TreeNode(20, "twenty");
        root.rightChild = new TreeNode(60, "sixty");
        root.leftChild.leftChild = new TreeNode(10, "ten");
        root.leftChild.rightChild = new TreeNode(30, "thirty");
        root.rightChild.leftChild = new TreeNode(50, "fifty");
        root.rightChild.rightChild = new TreeNode(70, "seventy");

        isBST = isBST(root);
        System.out.println(isBST);
    }

    //method to trigger check
    public static boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //recursive function which checks for all the nodes
    private static boolean isBST(TreeNode root, int minValue, int maxValue) {

        //if root is null, it's a BST
        if (root == null) {
            return true;
        }
        //if root data is equals to either of min or max then it's not valid BST
        if (root.data <= minValue || root.data > maxValue) {
            return false;
        }
        //repeat for the all the nodes from the top
        return isBST(root.leftChild, minValue, root.data) && isBST(root.rightChild, root.data, maxValue);
    }

    //TODO -
    private boolean isBSTNonRecursive(TreeNode root) {
        return false;
    }

}