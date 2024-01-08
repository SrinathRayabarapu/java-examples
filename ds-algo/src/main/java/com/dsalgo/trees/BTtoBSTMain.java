package com.dsalgo.trees;

/**
 * given a binary tree, convert it in to binary search tree that has minimum possible height.
 *
 * https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
 *
 * TODO:
 *
 * @author Srinath.Rayabarapu
 */
public class BTtoBSTMain {

    public static void main(String[] args) {

        // this creates skewed binary tree
        CustomBinaryTree bTree = new CustomBinaryTree();
        bTree.addNode(70);
        bTree.addNode(20);
        bTree.addNode(40);
        bTree.addNode(80);
        bTree.addNode(10);
        bTree.addNode(30);
        bTree.addNode(90);

        bTree.printTree();

        buildBinarySearchTree(bTree.root);

    }

    private static void buildBinarySearchTree(TreeNode root) {

    }

}
