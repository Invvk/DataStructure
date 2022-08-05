package io.github.invvk.ds.stack;

import io.github.invvk.ds.linkedlist.singly.SinglyLinkedList;

public class Stack<T> {

    private final SinglyLinkedList<T> list;

    public Stack() {
        list = new SinglyLinkedList<>();
    }

    public Stack(T defaultValue) {
        list = new SinglyLinkedList<>(defaultValue);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(T value) {
        this.list.insertToHead(value);
    }

    public T pop() {
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
