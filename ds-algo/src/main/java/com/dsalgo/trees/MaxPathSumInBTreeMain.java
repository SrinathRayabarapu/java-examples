package com.dsalgo.trees;

public class MaxPathSumInBTreeMain {

    public static void main(String[] args) {

        TreeNode root = TreeUtil.create6NodesTree();
        root.rightChild.rightChild.rightChild = new TreeNode(100);

        System.out.println("Max path sum : " + maxPath(root));
    }

    private static int maxPath(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxPath(root.leftChild) + root.data, maxPath(root.rightChild) + root.data);
    }

}
