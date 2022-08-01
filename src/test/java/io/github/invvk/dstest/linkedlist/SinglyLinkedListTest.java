package io.github.invvk.dstest.linkedlist;

import io.github.invvk.ds.linkedlist.singly.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinglyLinkedListTest {

    @Test
    public void validateHeadImplementation() {
        SinglyLinkedList<Integer> slist = new SinglyLinkedList<>();

        slist.insertToHead(1);
        assertEquals(1, slist.getHead().getData(), "head should be 1 (slist is empty)");
        assertEquals(slist.getHead(), slist.getTail(), "head and tail are not the same (1 node slist)");

        slist.insertToHead(2);
        assertEquals(2, slist.getHead().getData(), "head should be 2 (slist is not empty)");
    }

    @Test
    public void validateTailImplementation() {
        SinglyLinkedList<Integer> slist = new SinglyLinkedList<>();

        slist.insertToTail(1);
        assertEquals(1, slist.getTail().getData(), "head should be 1 (slist is empty)");
        assertEquals(slist.getHead(), slist.getTail(), "head and tail are not the same (1 node slist)");

        slist.insertToTail(2);
        assertEquals(2, slist.getTail().getData(), "head should be 2 (slist is not empty)");
    }

    @Test
    public void validatePosImplementation() {
        SinglyLinkedList<Integer> slist = new SinglyLinkedList<>();

        slist.insertToPos(1, 10);
        assertEquals(10, slist.getHead().getData(), "insert to position: head");

        slist.insertToPos(slist.size() + 1, 20);
        assertEquals(20, slist.getTail().getData(), "insert to position: tail");

        slist.insertToPos(2, 15);
        int data = slist.getNodeAt(2).getData();
        assertEquals(15, data, "insert to position: position");
    }

    @Test
    public void validateDeleteHeadImplementation() {
        SinglyLinkedList<Integer> slist = new SinglyLinkedList<>(-1);
        slist.insertToHead(1);
        slist.insertToHead(2);
        slist.insertToHead(3);
        slist.insertToHead(4);

        int deleted = slist.deleteFromHead();
        assertEquals(4, deleted, "delete from head");
    }

    @Test
    public void validateDeleteTailImplementation() {
        SinglyLinkedList<Integer> slist = new SinglyLinkedList<>(-1);
        slist.insertToHead(1);
        slist.insertToHead(2);
        slist.insertToHead(3);
        slist.insertToHead(4);

        int deleted = slist.deleteFromTail();
        assertEquals(1, deleted, "delete from tail");
    }

}
