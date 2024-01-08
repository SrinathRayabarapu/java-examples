package com.dsalgo.trees;

import lombok.extern.slf4j.Slf4j;

/**
 * given a binary tree, print it's boundary i.e left -> bottom -> right bottom to top
 * <p>
 * https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class AntiClockwiseBoundaryTraversalOfBinaryTreeMain {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(40, "forty");
        root.leftChild = new TreeNode(20, "twenty");
        root.rightChild = new TreeNode(60, "sixty");
        root.leftChild.leftChild = new TreeNode(10, "ten");
        root.leftChild.rightChild = new TreeNode(30, "thirty");
        root.rightChild.leftChild = new TreeNode(50, "fifty");
        root.rightChild.rightChild = new TreeNode(70, "seventy");

        printBoundaries(root);

    }

    private static void printBoundaries(TreeNode root) {
        if (root != null) {
            System.out.println(root.data);

            printLeftBoundary(root.leftChild);

            printLeaves(root.leftChild);
            printLeaves(root.rightChild);

            printRightBoundary(root.rightChild);
        }
    }

    private static void printRightBoundary(TreeNode rightChild) {
        if (rightChild != null) {
            if (rightChild.rightChild != null) {
                System.out.println(rightChild.data);
                printRightBoundary(rightChild.rightChild);
            } else if (rightChild.leftChild != null) {
                System.out.println(rightChild.data);
                printRightBoundary(rightChild.leftChild);
            }
        }
    }

    private static void printLeaves(TreeNode child) {
        if (child != null) {
            printLeaves(child.leftChild);
            if (child.leftChild == null && child.rightChild == null) {
                System.out.println(child.data);
            }
            printLeaves(child.rightChild);
        }
    }

    private static void printLeftBoundary(TreeNode leftChild) {
        if (leftChild != null) {
            if (leftChild.leftChild != null) {
                System.out.println(leftChild.data);
                printLeftBoundary(leftChild.leftChild);
            } else if (leftChild.rightChild != null) {
                System.out.println(leftChild.data);
                printLeftBoundary(leftChild.rightChild);
            }
        }
    }

}
