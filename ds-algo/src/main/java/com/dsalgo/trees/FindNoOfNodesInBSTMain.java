package com.dsalgo.trees;

import lombok.extern.slf4j.Slf4j;

/**
 * given the root node of tree, count the number of nodes in it.
 */
@Slf4j
public class FindNoOfNodesInBSTMain {

    public static void main(String[] args) {

        TreeNode root = TreeUtil.create6NodesTree();
        int nodesCount = findNoOfNodesInBST(root);
        log.info("nodesCount: " + nodesCount);

    }

    /**
     * TC: O(n) - n is the number of nodes in the tree
     * SC: O(h) - h is the height of the tree
     * @param root
     * @return
     */
    private static int findNoOfNodesInBST(TreeNode root) {
        if(root == null) return 0;
        return findNoOfNodesInBST(root.leftChild) + findNoOfNodesInBST(root.rightChild) + 1;
    }

}