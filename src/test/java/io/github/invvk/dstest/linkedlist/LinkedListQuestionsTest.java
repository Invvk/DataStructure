package io.github.invvk.dstest.linkedlist;

import io.github.invvk.ds.linkedlist.LinkedListQuestions;
import io.github.invvk.ds.linkedlist.singly.SNode;
import io.github.invvk.ds.linkedlist.singly.SinglyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListQuestionsTest {

    @Test
    public void validateCount3() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.insertToHead(1);
        linkedList.insertToHead(3);
        linkedList.insertToHead(5);
        linkedList.insertToHead(9);
        linkedList.insertToHead(11);

        int expected = 2;
        int actual = LinkedListQuestions.count3(linkedList);
        assertEquals(expected, actual);
    }

    @Test
    public void validateInsertToMiddle() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.insertToHead(1);
        linkedList.insertToHead(3);
        linkedList.insertToHead(5);
        linkedList.insertToHead(9);
        int expected = 2;
        LinkedListQuestions.insertMiddle(linkedList, expected);

        assertEquals(expected, linkedList.getNodeAt(3).getData());

        expected = 20;
        LinkedListQuestions.insertMiddle(linkedList, expected);
        assertEquals(expected, linkedList.getNodeAt(3).getData());
        assertEquals(expected, linkedList.getNodeAt(5).getData());
    }

    @Test
    public void validateReverse() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        linkedList.insertToHead(1);
        linkedList.insertToHead(3);
        linkedList.insertToHead(5);
        linkedList.insertToHead(9);

        int tailVal = linkedList.getTail().getData();

        LinkedListQuestions.reverse(linkedList);
        linkedList.print();
        assertEquals(tailVal, linkedList.getHead().getData());
    }

    @Test
    public void validateDeleteEven() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        linkedList.insertToHead(1);
        linkedList.insertToHead(2);
        linkedList.insertToHead(5);
        linkedList.insertToHead(4);

        LinkedListQuestions.deleteEven(linkedList);
        linkedList.forEach(node -> {
            int data = node.getData();
            assertTrue(data % 2 != 0);
        });
    }

    @Test
    public void validateRepeatAll() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        linkedList.insertToHead(1);
        linkedList.insertToHead(2);
        linkedList.insertToHead(5);
        linkedList.insertToHead(4);

        LinkedListQuestions.repeatAll(linkedList);

        // Validation
        SNode<Integer> node = linkedList.getHead();
        while (node != null) {
            int x = node.getNext().getData();
            int y = node.getData();
            assertEquals(x, y);
            node = node.getNext().getNext();
        }
    }

    @Test
    public void validateSortAscendingMethod() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        linkedList.insertToHead(2);
        linkedList.insertToHead(4);
        linkedList.insertToHead(5);
        linkedList.insertToHead(1);

        LinkedListQuestions.sortAscending(linkedList);

        // Validation
        SNode<Integer> node = linkedList.getHead();
        while (node != null) {
            int x = node.getNext().getData();
            int y = node.getData();
            Assertions.assertTrue(y <= x);
            node = node.getNext().getNext();
        }
    }

}
