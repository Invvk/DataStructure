package io.github.invvk.ds.linkedlist.singly;

import io.github.invvk.ds.linkedlist.ILinkedList;

public class SinglyLinkedList<T> implements ILinkedList<T, SNode<T>> {

    private SNode<T> head, tail;
    private int counter;

    private T defaultValue;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public SNode<T> getNodeAt(int pos) {
        if (pos < 1 || pos > counter)
            throw new IndexOutOfBoundsException("node is out of bound, size = " + size() + " pos = " + pos);

        SNode<T> SNode = head;
        for (int i = 1; i < pos; i++)
            SNode = SNode.getNext();

        return SNode;
    }

    public void insertToHead(T value) {
        if (isEmpty()) {
            SNode<T> SNode = new SNode<>(value);
            SNode.setNext(null);
            head = tail = SNode;
        } else {
            SNode<T> SNode = new SNode<>(value);
            SNode.setNext(head);
            head = SNode;
        }
        counter++;
    }

    public void insertToTail(T value) {
        if (isEmpty())
            insertToHead(value);
        else {
            SNode<T> SNode = new SNode<>(value);
            SNode.setNext(null);
            tail.setNext(SNode);
            tail = SNode;
        }
        counter++;
    }

    public void insertToPos(int pos, T value) {
        if (pos < 1 || pos > counter + 1)
            throw new IndexOutOfBoundsException("Position can't be greater than size+1 or less than 1");

        if (pos == 1)
            this.insertToHead(value);
        else if (pos == counter+1)
            this.insertToTail(value);
        else {
            SNode<T> SNode = new SNode<>(value);
            SNode<T> t = getNodeAt(pos - 1);
            SNode.setNext(t.getNext());
            t.setNext(SNode);
            counter++;
        }
    }

    public T deleteFromHead() {
        if (isEmpty())
            return defaultValue;
        T data = head.getData();
        if (head == tail)
            head = tail = null;
        else
            head = head.getNext();
        counter--;
        return data;
    }

    public T deleteFromTail() {
        if (isEmpty())
            return defaultValue;
        T data = tail.getData();
        if (head == tail)
            head = tail = null;
        else {
            SNode<T> node = getNodeAt(size() - 1);
            node.setNext(null);
            tail = node;
        }
        counter--;
        return data;
    }

    public T deleteFromPos(int pos) {
        if (pos < 1 || pos > counter + 1)
            throw new IndexOutOfBoundsException("Position can't be greater than size+1 or less than 1");

        T data = defaultValue;
        if (isEmpty())
            return data;

        if (pos == 1)
            return deleteFromHead();
        else if (pos == counter + 1)
            return deleteFromTail();
        else {
            SNode<T> t = getNodeAt(pos - 1);
            SNode<T> del = t.getNext();
            data = del.getData();
            t.setNext(del.getNext());
            counter--;
        }
        return data;
    }

    public void print() {
        SNode<T> t = head;
        while (t != null) {
            System.out.println(t.getData());
            t = t.getNext();
        }
    }

    public SNode<T> getHead() {
        return head;
    }

    public SNode<T> getTail() {
        return tail;
    }

    @Override
    public void setHead(SNode<T> head) {
        this.head = head;
    }

    @Override
    public void setTail(SNode<T> tail) {
        this.tail = tail;
    }

    public int size() {
        return counter;
    }
}
