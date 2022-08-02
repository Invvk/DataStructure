package io.github.invvk.ds.linkedlist;


import io.github.invvk.ds.linkedlist.singly.SNode;
import io.github.invvk.ds.linkedlist.singly.SinglyLinkedList;

public class LinkedListQuestions {

    /**
     * a method that finds the amount of elements that are divisible by 3
     */
    public static int count3(ILinkedList<Integer, ?> linkedList) {
        int x = 0;

        if (linkedList.isEmpty())
            return x;

        INode<Integer, ?> t =  linkedList.getHead();
        while (t != null) {
            if (t.getData() % 3 == 0)
                x++;
            t = t.getNext();
        }
        return x;
    }

    /**
     * insert value to middle
     */
    public static void insertMiddle(ILinkedList<Integer, ?> linkedList, int val) {
        if (linkedList.isEmpty())
            return;
        if (linkedList.size() % 2 == 0)
            linkedList.insertToPos(linkedList.size() / 2 + 1, val);
        else {
            linkedList.insertToPos(linkedList.size() / 2 + 1, val);
            linkedList.insertToPos(linkedList.size() / 2 + 2, val);
        }
    }

    /**
     * Reverse a linked list
     */
    public static <T> void reverse(SinglyLinkedList<T> linkedList) {
        // prevent reverting empty linked list or linked list with 1 node
        if (linkedList.isEmpty() || linkedList.size() == 1)
            return;

        SNode<T> t1 = linkedList.getHead();
        SNode<T> t2 = t1.getNext();

        // Guard Clause for a Linked List with 2 nodes
        if (linkedList.size() == 2) {
            t2.setNext(t1);
            t1.setNext(null);
            linkedList.setHead(t2);
            linkedList.setTail(t2.getNext());
            return;
        }

        SNode<T> t3 = t2.getNext();
        while (t3 != null) {
            t2.setNext(t1);
            t1 = t2;
            t2 = t3;
            t3 = t3.getNext();
        }
        t2.setNext(t1);
        linkedList.getHead().setNext(null);
        linkedList.setTail(linkedList.getHead());
        linkedList.setHead(t2);
    }

    /**
     * Delete all node that contains an even number
     */
    public static void deleteEven(ILinkedList<Integer, ?> linkedList) {
        if (linkedList.isEmpty())
            return;

        int i = 1;
        INode<Integer, ?> t = linkedList.getHead();
        while (t != null) {
            if (t.getData() % 2 == 0)
                linkedList.deleteFromPos(i);
            else i++;
            t = t.getNext();
        }
    }

    /**
     * Repeat all nodes
     */
    public static <T> void repeatAll(ILinkedList<T, ?> linkedList) {
        if (linkedList.isEmpty())
            return;

        int i = 1;
        INode<T, ?> t = linkedList.getHead();
        while (t != null) {
            linkedList.insertToPos(i+1, t.getData());
            i+=2;
            t = t.getNext().getNext();
        }
    }

    /**
     * Sort singly linked list
     */
    public static void sortAscending(SinglyLinkedList<Integer> linkedList) {
        SNode<Integer> node = linkedList.getHead();
        while (node != null) {
            SNode<Integer> index = node.getNext();
            while (index != null) {
                if (node.getData() > index.getData()) {
                    int temp = node.getData();
                    node.setData(index.getData());
                    index.setData(temp);
                }
                index = index.getNext();
            }
            node = node.getNext();
        }
    }

}
