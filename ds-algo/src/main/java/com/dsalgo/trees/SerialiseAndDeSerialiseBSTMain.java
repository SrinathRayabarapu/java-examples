package com.dsalgo.trees;

/**
 * given a binary tree, serialize and deserialize.
 */
public class SerialiseAndDeSerialiseBSTMain {

    public static void main(String[] args) {

        TreeNode root = TreeUtil.create6NodesTree();
        root.leftChild.leftChild.leftChild = new TreeNode(5, "five");

        String serialisedString = serialise(root);

        System.out.println("serialisedString = " + serialisedString);

        root = deserialise(serialisedString);

        serialisedString = serialise(root);

        System.out.println("serialisedString = " + serialisedString);
    }

    private static TreeNode deserialise(String serialisedString) {
        return null;
    }

    private static String serialise(TreeNode root) {
        return null;
    }

}
