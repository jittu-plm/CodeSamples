package com.jitendra.ds;

public class MyLinkedList {

    public static boolean reverse = false;

    static class Node{
        int data;
        Node next;
    }


    //create normal or reverse list
    static  Node createList(){
        Node head = null;
        Node temp = null;
        head = push(head, 10);
        temp = head;
        head = push(head, 1);
        head = push(head, 6);
        head = push(head, 3);
        head = push(head, 9);
        head = push(head, 12);
        head = push(head, 5);

        if(reverse)
            return head;
        else
            return temp;
    }


    static Node push(Node head, int data){
        if(reverse) {
            Node node = new Node();
            node.data = data;
            node.next = head;
            head = node;
        }
        else {
            Node node = new Node();
            node.data = data;
            if (head != null)
                head.next = node;
            head = node;
            node.next = null;
        }
        return head;
    }


    static void printList(Node node){
        while( node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    //create normal or reverse list
    static  Node createCircularList(){
        Node head = null;
        Node temp = null;
        head = push(head, 10);
        temp = head;
        head = push(head, 1);
        head = push(head, 6);
        head = push(head, 3);
        head = push(head, 9);
        head = push(head, 12);
        head = push(head, 5);
        head.next = temp;

        return temp;
    }

    static  boolean checkCircular(Node head){
        Node fast = head;
        Node slow = head;

        while(fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast!= null && slow != null && (fast == slow || fast.next == slow.next)){
                return true;
            }
        }
        return false;
    }




    public static void main(String[] args) {
        Node head = null;
        //creating normal list
        head = createList();
        printList(head);
        System.out.println();
        System.out.println("is circular : " + checkCircular(head));
        //creating reverse list
        reverse = true;
        head = createList();
        printList(head);
        System.out.println();
        System.out.println("is circular : " + checkCircular(head));
        System.out.println();
        //create circular and test circular
        reverse = false;
        head = createCircularList();
        System.out.println("is circular : " + checkCircular(head));
    }
}



