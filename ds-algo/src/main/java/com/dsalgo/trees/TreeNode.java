package com.dsalgo.trees;

/**
 * Tree node for all tree operations
 *
 * @author Srinath.Rayabarapu
 */
public class TreeNode {

    int data;
    String name;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, String name) {
        this.data = data;
        this.name = name;
    }

	/**
	 * this operation assumes the value is being inserted on to a BST!
	 *
	 * @param value
	 */
    public void insert(int value) {
        if (value <= this.data) {
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(value);
            } else {
                this.leftChild.insert(value);
            }
        } else {
            if (this.rightChild == null) {
                this.rightChild = new TreeNode(value);
            } else {
                this.rightChild.insert(value);
            }
        }
    }

	/**
	 *
	 * @param value
	 * @return
	 */
    public boolean contains(int value) {

        if (this.data == value)
            return true;

        if (value < this.data) {
            if (this.leftChild == null) {
                return false;
            } else {
				this.leftChild.contains(value);
            }
        } else {
			if (this.rightChild == null) {
				return false;
			} else {
				this.rightChild.contains(value);
			}
		}

        return false;
    }

    @Override
    public String toString() {
        return this.name + " has data " + this.data;
    }

}
