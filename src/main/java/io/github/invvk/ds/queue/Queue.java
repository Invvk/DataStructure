package io.github.invvk.ds.queue;

import io.github.invvk.ds.linkedlist.singly.SinglyLinkedList;

public class Queue<T> {

    private final SinglyLinkedList<T> list;

    public Queue() {
        list = new SinglyLinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void queue(T value) {
        this.list.insertToTail(value);
    }

    public T dequeue() {
        return this.list.deleteFromHead();
    }

    public T top() {
        T val = null;
        if (list.getHead() != null)
            val = list.getHead().getData();
        return val;
    }

    public int size() {
        return this.list.size();
    }

    public void print() {
        list.print();
    }

}
