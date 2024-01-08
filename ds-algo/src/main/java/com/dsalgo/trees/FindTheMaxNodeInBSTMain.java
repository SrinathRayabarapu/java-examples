package com.dsalgo.trees;

import lombok.extern.slf4j.Slf4j;

/**
 * given a tree with root node, find the maximum node with data.
 */
@Slf4j
public class FindTheMaxNodeInBSTMain {

    public static void main(String[] args) {
        // max(max(left), max(right))
        TreeNode root = TreeUtil.create6NodesTree();

        int max = findTheMaxNode(root);
        log.info("Max: " + max);

    }

    private static int findTheMaxNode(TreeNode root) {
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int maxChildData = Math.max(findTheMaxNode(root.leftChild), findTheMaxNode(root.rightChild));
        return Math.max(maxChildData, root.data);
    }

}
