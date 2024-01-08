package com.dsalgo.stacksnqueues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Given a Linkedlist, implement a Stack operations push and pop.
 *
 * Idea:
 * 1. Push elements at the beginning of the Linked list
 * 2. Remove elements from the beginning of the Linked list
 *e
 * @author Srinath.Rayabarapu
 */
public class StackImplUsingLinkedListMain {

    public static void main(String[] args) {
        LinkedListStack<String> list = new LinkedListStack<>();
        list.push("a");
        list.push("z");
        list.push("c");
        list.push("b");

        System.out.println("Printing from Stack");
        list.print();

        System.out.println("Two elements Popped");
        System.out.println(list.pop().getT());
        System.out.println(list.pop().getT());

        System.out.println("Printing from Stack");
        list.print();
    }

}

class LinkedListStack<T>{

    private static final Logger LOG = LoggerFactory.getLogger(LinkedListStack.class);

    private Node<T> head;

    public Node<T> pop(){
        Node<T> temp = head;
        head = head.getNext();
        return temp;
    }

    public void push(T t){
        if(head == null){
            head = new Node<>(t, null);
        } else {
            Node<T> temp = new Node<>(t, null);
            temp.setNext(head);
            head = temp;
        }
    }

    public void print(){
        Node<T> temp = head;
        if(head != null){
            while (head != null){
                System.out.println(head.getT());
                head = head.getNext();
            }
        } else{
            LOG.info("List is empty!");
        }
        head = temp;
    }
}

/**
 * generic Node class
 *
 * @param <T>
 */
class Node<T>{

    T t;
    Node next;

    Node(T t, Node next){
        this.t = t;
        this.next = next;
    }

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

}