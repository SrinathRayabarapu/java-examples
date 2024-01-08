package com.dsalgo.linkedlist;

/**
 * Node object to point to next Object in the chain if no link is passed then
 * null by default
 *
 * @author Srinath.Rayabarapu
 */
public class Node {

    private Node next;
    private Object data;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    /**
     * @return the next
     */
    public Node getNext() {
        return this.next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return this.data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
