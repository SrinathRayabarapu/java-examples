package com.dsalgo.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.dsalgo.linkedlist.DeleteNodeInLinkedListMain.deleteNode;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeleteNodeInLinkedListMainTest {

    Node n1 = null;

    @BeforeEach
    void setUp() {
        n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60);
        Node n7 = new Node(70);
        Node n8 = new Node(80);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);
    }

    @Test
    void givenNullLinkedList_whenDeleteNodeCalled_thenShouldNotThrowAnyException_() {
        deleteNode(null, 1);
        assertTrue(true);
    }


}