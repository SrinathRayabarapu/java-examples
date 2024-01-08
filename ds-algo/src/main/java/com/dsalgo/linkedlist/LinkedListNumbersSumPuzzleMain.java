package com.dsalgo.linkedlist;

/**
 * given two linked lists in reverse ordered, reverse them and sum the number and create another linked list in
 * reverse order
 *
 * Ex: [1, 2, 3] and [4, 5, 6] are two linked lists.
 * 321 + 654 sum is 975
 * output is [5, 7, 9]
 *
 * @author Srinath.Rayabarapu
 */
public class LinkedListNumbersSumPuzzleMain {

    public static void main(String[] args) {

        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        head.setNext(n2);
        n2.setNext(n3);

        Node head1 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        head1.setNext(n5);
        n5.setNext(n6);

        Node head2 = calculate(head, head1);

        System.out.println("Printing the Linkedlist : ");
        LinkedListUtil.printLinkedList(head2);
    }

    private static Node calculate(Node head, Node head1) {

        int value1 = getNumber(head);
        int value2 = getNumber(head1);

        System.out.println("value1 : " + value1 + ", value2 : " + value2);

        int sum = value1 + value2;
        return createList(sum);
    }

    private static Node createList(int sum) {

        System.out.println("sum : " + sum);

        Node head = null, temp = null;
        String sumStr = sum + "";
        for (int i = sumStr.length()-1; i >= 0 ; i--) {
            if(temp == null){
                temp = new Node(sumStr.charAt(i));
                head = temp;
            } else {
                temp.setNext(new Node(sumStr.charAt(i)));
                temp = temp.getNext();
            }
        }
        return head;
    }

    private static int getNumber(Node head) {
        String number = "";
        while (head != null){
            number = head.getData() + number;
            head = head.getNext();
        }
        return Integer.valueOf(number);
    }

}
