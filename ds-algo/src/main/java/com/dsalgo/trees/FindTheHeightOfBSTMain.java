package com.dsalgo.trees;

import lombok.extern.slf4j.Slf4j;

/**
 * given a tree with root node, find the height
 *
 * Height : No. of edges between the root node to the farthest leaf node.
 */
@Slf4j
public class FindTheHeightOfBSTMain {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.create9NodesTree();
        int height = findTheHeight(root);
        log.info("Height: " + height);
    }

    private static int findTheHeight(TreeNode root) {
        if(root == null)
            return -1;
        return Math.max(findTheHeight(root.leftChild), findTheHeight(root.rightChild)) + 1;
    }

}
