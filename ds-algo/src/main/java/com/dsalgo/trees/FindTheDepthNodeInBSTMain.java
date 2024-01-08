package com.dsalgo.trees;

import lombok.extern.slf4j.Slf4j;

/**
 * given a tree with root and a node, find the depth of the node
 * <p>
 * Depth of Node : Edges from root to the node.
 */
@Slf4j
public class FindTheDepthNodeInBSTMain {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.create9NodesTree();
        int depth = findDepth(root, 10);
        log.info("Depth: " + depth);
    }

    private static int findDepth(TreeNode root, int input) {
        if (root == null)
            return -1;
        if (root.data == input) {
            return 0;
        }
        int leftDepth = findDepth(root.leftChild, input);
        int rightDepth = findDepth(root.rightChild, input);
        if (leftDepth == -1 && rightDepth == -1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

}