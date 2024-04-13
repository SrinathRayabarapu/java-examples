package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * given a binary tree, serialize and deserialize.
 */
public class SerialiseAndDeSerialiseBSTMain {

    public static void main(String[] args) {

        TreeNode root = TreeUtil.create6NodesTree();
        root.leftChild.leftChild.leftChild = new TreeNode(5, "five");

        List<String> list = new ArrayList<>();

        serialise(root, list);

        System.out.println("list.toArray().toString() = " + list);

        List<Integer> indexList = new ArrayList<>();
        indexList.add(-1);
        root = deserialise(list, indexList);

        list.clear();

        System.out.println("list.toArray().toString() = " + list);

        serialise(root, list);

        System.out.println("list.toArray().toString() = " + list);
    }

    /**
     * Deserializing from list. Move each element forward once the node is created
     *
     * @param list
     * @param indexList
     * @return
     */
    private static TreeNode deserialise(List<String> list, List<Integer> indexList) {

        indexList.add(0, indexList.get(0)+1);

        if("N".equals(list.get(indexList.get(0)))){
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(list.get(indexList.get(0))));

        node.leftChild = deserialise(list, indexList);
        node.rightChild = deserialise(list, indexList);

        return node;
    }

    /**
     * serializing in pre-order traversal
     *
     * @param root
     * @param list
     */
    private static void serialise(TreeNode root, List<String> list) {

        if (root == null){
            list.add("N");
            return;
        }

        list.add(root.data+"");
        serialise(root.leftChild, list);
        serialise(root.rightChild, list);
    }

}