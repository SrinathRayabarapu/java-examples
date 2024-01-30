package com.dsalgo.trees;

public class MaxWidthOfBTreeMain {

    public static void main(String[] args) {

        TreeNode root = TreeUtil.create6NodesTree();
        root.rightChild.rightChild.rightChild = new TreeNode(100);

        System.out.println("Max width : " + maxWidth(root));
    }

    private static int maxWidth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxWidth(root.leftChild), maxWidth(root.rightChild)) + 1;
    }

}
