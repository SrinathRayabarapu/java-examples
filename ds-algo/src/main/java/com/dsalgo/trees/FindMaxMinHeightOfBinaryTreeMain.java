package com.dsalgo.trees;

import lombok.extern.slf4j.Slf4j;

/**
 * given a binary search tree, find it's max height.
 *
 * Idea: find left and right children heights and compare then return
 * https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class FindMaxMinHeightOfBinaryTreeMain {

    public static void main(String[] args) {

        // binary search tree - but can be any binary tree!
        TreeNode root = TreeUtil.create9NodesTree();

        System.out.println("Max height is : " + maxHeight(root));
        System.out.println("Min height is : " + minHeight(root));

    }

    static int maxHeight(TreeNode root){
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxHeight(root.leftChild), maxHeight(root.rightChild));
    }

    static int minHeight(TreeNode root){
        if(root == null) {
            return 0;
        }
        return 1 + Math.min(minHeight(root.leftChild), minHeight(root.rightChild));
    }

}
