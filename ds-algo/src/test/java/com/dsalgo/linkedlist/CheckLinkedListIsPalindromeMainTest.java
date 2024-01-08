package com.dsalgo.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckLinkedListIsPalindromeMainTest {

    @Test
    void isLinkedListPalindrome() {

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(30);
        Node n5 = new Node(20);
        Node n6 = new Node(10);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);

        boolean isPalindrome = CheckLinkedListIsPalindromeMain.isLinkedListPalindrome(n1);

        assertTrue(isPalindrome);
    }
}