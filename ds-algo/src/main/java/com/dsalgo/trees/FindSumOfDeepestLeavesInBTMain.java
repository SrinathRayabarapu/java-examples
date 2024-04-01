package com.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * given a tree, find the sum of leaf nodes
 */
public class FindSumOfDeepestLeavesInBTMain {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.create6NodesTree();

        int sum = findSumIterative(root);

//        int sum = findSumRecursive(root);
        System.out.println("sum = " + sum);

    }

    /**
     * TC: O(n)
     * SC: O(n)
     *
     * @param root
     * @return
     */
    private static int findSumRecursive(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.leftChild == null || root.rightChild == null){
            return root.data;
        }
        return findSumRecursive(root.leftChild) + findSumRecursive(root.rightChild);
    }

    private static int findSumIterative(TreeNode root) {

        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int sum = 0;

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.leftChild == null || node.rightChild == null){
                sum += node.data;
            }

            if(node.leftChild != null){
                queue.offer(node. leftChild);
            }

            if(node.rightChild != null){
                queue.offer(node.rightChild);
            }
        }

        return sum;
    }

}