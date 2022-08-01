package io.github.invvk.ds.linkedlist.doubly;

import io.github.invvk.ds.linkedlist.ILinkedList;

public class DoublyLinkedList<T> implements ILinkedList<T, DNode<T>> {

    private DNode<T> head, tail;
    private int counter;

    private T defaultValue;

    public DoublyLinkedList() {}

    public DoublyLinkedList(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public DNode<T> getNodeAt(int pos) {
        if (pos < 1 || pos > counter)
            throw new IndexOutOfBoundsException("node is out of bound, size = " + size() + " pos = " + pos);

        DNode<T> DNode = head;
        for (int i = 1; i < pos; i++)
            DNode = DNode.getNext();

        return DNode;
    }

    @Override
    public void insertToHead(T value) {
        if (isEmpty()) {
            DNode<T> DNode = new DNode<>(value);
            DNode.setNext(null);
            DNode.setPrevious(null);
            head = tail = DNode;
        } else {
            DNode<T> DNode = new DNode<>(value);
            DNode.setNext(head);
            DNode.setPrevious(null);
            head.setPrevious(DNode);
            head = DNode;
        }
        counter++;
    }

    @Override
    public void insertToTail(T value) {
        if (isEmpty())
            insertToHead(value);
        else {
            DNode<T> DNode = new DNode<>(value);
            DNode.setNext(null);
            DNode.setPrevious(tail);
            tail.setNext(DNode);
            tail = DNode;
        }
        counter++;
    }

    @Override
    public void insertToPos(int pos, T value) {
        if (pos < 1 || pos > counter + 1)
            throw new IndexOutOfBoundsException("Position can't be greater than size+1 or less than 1");

        if (pos == 1)
            this.insertToHead(value);
        else if (pos == counter+1)
            this.insertToTail(value);
        else {
            DNode<T> t = getNodeAt(pos - 1);

            DNode<T> DNode = new DNode<>(value);
            DNode.setNext(t.getNext());
            DNode.setPrevious(t);
            DNode.getNext().setPrevious(DNode);
            t.setNext(DNode);
            counter++;
        }
    }

    public T deleteFromHead() {
        if (isEmpty())
            return defaultValue;
        T data = head.getData();
        if (head == tail)
            head = tail = null;
        else {
            head = head.getNext();
            head.setPrevious(null);
        }
        counter--;
        return data;
    }

    @Override
    public T deleteFromTail() {
        if (isEmpty())
            return defaultValue;
        T data = tail.getData();
        if (head == tail)
            head = tail = null;
        else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        counter--;
        return data;
    }

    @Override
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
            DNode<T> t = getNodeAt(pos - 1);
            DNode<T> del = t.getNext();
            data = del.getData();
            del.getNext().setPrevious(t);
            t.setNext(del.getNext());
            counter--;
        }
        return data;
    }

    @Override
    public void print() {
        DNode<T> t = head;
        while (t != null) {
            System.out.println(t.getData());
            t = t.getNext();
        }
    }

    public DNode<T> getHead() {
        return head;
    }

    public DNode<T> getTail() {
        return tail;
    }

    @Override
    public void setHead(DNode<T> head) {
        this.head = head;
    }

    @Override
    public void setTail(DNode<T> tail) {
        this.tail = tail;
    }

    public int size() {
        return counter;
    }
}
