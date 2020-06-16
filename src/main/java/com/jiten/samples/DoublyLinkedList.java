package com.jiten.samples;

/**
 * Double linked list
 * @author jittu
 *
 */
public class DoublyLinkedList {
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.addNodeAtEnd(10);
        dll.addNodeAtEnd(20);
        dll.addNodeAtEnd(30);
        dll.addNodeAtFront(5);
        dll.addNodeAtFront(1);
        dll.insertAfter(dll.head,3);
        dll.print(dll.head);
    }
}

class DLL {
    Node head;
    static class Node {
        Node prev;
        Node next;
        int data;

        Node(int data){
            this.data = data;
        }
    }

    //add node at the front
    public void addNodeAtFront(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;

        if(head != null){
            head.prev = newNode;
        }
        head = newNode;
    }


    //add node at the end
    public void addNodeAtEnd(int data){
        Node newNode = new Node(data);

        //if the list is empty
        if(head == null){
            newNode.prev = null;
            head = newNode;
            return;
        }

        //if the list is not empty
        Node current = head;
        while (current.next != null){
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;
    }

    //insert after
    public void insertAfter(Node prev, int data){
        if(prev == null){
            return;
        }

        Node newNode = new Node(data);
        newNode.next = prev.next;
        prev.next = newNode;
        newNode.prev = prev;
        if(newNode != null){
            newNode.next.prev = newNode;
        }
    }


    //print
    public void  print(Node node){
        while (node.next != null){
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print(node.data + " -> null");

        System.out.println();
    }
}
