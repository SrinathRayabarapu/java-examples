package com.dsalgo.trees;

public class TreeUtil {

    private TreeUtil() {}

    public static TreeNode create6NodesTree() {
        TreeNode root = new TreeNode(60, "sixty");
        root.leftChild = new TreeNode(30, "thirty");
        root.rightChild = new TreeNode(80, "eighty");
        root.leftChild.leftChild = new TreeNode(10, "ten");
        root.leftChild.rightChild = new TreeNode(50, "fifty");
        root.rightChild.leftChild = new TreeNode(70, "seventy");
        root.rightChild.rightChild = new TreeNode(90, "ninety");
        return root;
    }

    public static TreeNode create9NodesTree() {
        TreeNode root = new TreeNode(40, "forty");
        root.leftChild = new TreeNode(20, "twenty");
        root.rightChild = new TreeNode(60, "sixty");
        root.leftChild.leftChild = new TreeNode(10, "ten");
        root.leftChild.leftChild.leftChild = new TreeNode(5, "five");
        root.leftChild.leftChild.rightChild = new TreeNode(15, "fifteen");
        root.leftChild.rightChild = new TreeNode(30, "thirty");
        root.rightChild.leftChild = new TreeNode(50, "fifty");
        root.rightChild.rightChild = new TreeNode(70, "seventy");
        return root;
    }

}