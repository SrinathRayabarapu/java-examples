package com.dsalgo.trees;

import lombok.extern.slf4j.Slf4j;

/**
 * this is only simple binary tree - NOT a binary search tree
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class CustomBinaryTree {

    static TreeNode root;

    public void addNode(int data){
        addNode(data, "");
    }

    /**
     * it simply checks and adds the elements to left or right of current node.
     *
     * @param data
     * @param name
     */
    public void addNode(int data, String name){

        TreeNode newNode = new TreeNode(data, name);
        if(root == null){
            root = newNode;
        }
        else {
            TreeNode focusNode = root;
            TreeNode parent;
            while(true){
                parent = focusNode;
                //if the data is less than focusNode then go to it's left child
                if(data < focusNode.data){
                    focusNode = focusNode.leftChild;
                    //if null then we are at the leaf child - insert new node here
                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    //then go to it's right child
                    focusNode = focusNode.rightChild;
                    //if null - insert new node here
                    if(focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void printTree(){
        printRecursive(root);
    }

    private void printRecursive(TreeNode root){
        if(root == null){
            log.info("Tree is empty!");
            return;
        }
        log.info("{}", root.data);
        if(root.leftChild != null){
            log.info(" -> left child : ");
            printRecursive(root.leftChild);
        }
        if(root.rightChild != null){
            log.info(" -> right child : ");
            printRecursive(root.rightChild);
        }
    }

}
