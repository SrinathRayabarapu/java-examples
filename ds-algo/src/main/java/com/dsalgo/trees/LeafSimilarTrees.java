package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/description/?envType=study-plan-v2&envId=leetcode-75
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
public class LeafSimilarTrees {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        boolean isLeavesSame = leafSimilar(root1, root2);
        System.out.println("isLeavesSame = " + isLeavesSame);
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leafsList1 = new ArrayList<>();
        findLeaves(root1, leafsList1);

        List<Integer> leafsList2 = new ArrayList<>();
        findLeaves(root2, leafsList2);

        return Arrays.equals(leafsList1.toArray(), leafsList2.toArray());
    }

    private static void findLeaves(TreeNode root, List<Integer> list) {

        if (root != null) {
            if (root.left != null){
                findLeaves(root.left, list);
            }
            if (root.right != null){
                findLeaves(root.right, list);
            }
            if(root.left == null && root.right == null){
                list.add(root.val);
            }
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

