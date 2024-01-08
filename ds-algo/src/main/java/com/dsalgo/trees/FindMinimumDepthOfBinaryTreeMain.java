package com.dsalgo.trees;

/**
 * TODO: complete it
 * <p>
 * https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
 * <p>
 * #coviam
 *
 * @author Srinath.Rayabarapu
 */
public class FindMinimumDepthOfBinaryTreeMain {

    public static void main(String[] args) {

    }

    int minimumDepth() {
        TreeNode head = null;
        return minimumDepth(head, 0);
    }

    /* Function to calculate the minimum depth of the tree */
    int minimumDepth(TreeNode root, int level) {

        if (root == null){
            return level;
        }

        level++;

        return Math.min(minimumDepth(root.leftChild, level), minimumDepth(root.rightChild, level));
    }

}