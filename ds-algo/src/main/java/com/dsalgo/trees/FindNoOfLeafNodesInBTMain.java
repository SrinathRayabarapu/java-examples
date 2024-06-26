package com.dsalgo.trees;

import lombok.extern.slf4j.Slf4j;

/**
 * given a binary tree, find no. of leaf nodes
 */
@Slf4j
public class FindNoOfLeafNodesInBTMain {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.create9NodesTree();
        int leafNodes = findNoOfLeafNodes(root);
        log.info("Leaf nodes: " + leafNodes);
    }

    private static int findNoOfLeafNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.leftChild == null && root.rightChild == null){
            return 1;
        }
        return findNoOfLeafNodes(root.leftChild) + findNoOfLeafNodes(root.rightChild);
    }

}
