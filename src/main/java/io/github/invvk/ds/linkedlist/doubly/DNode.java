package io.github.invvk.ds.linkedlist.doubly;

import io.github.invvk.ds.linkedlist.IDoublyNode;

public class DNode<T> implements IDoublyNode<T, DNode<T>> {

    private T data;
    private DNode<T> next,previous;

    public DNode() {}
    public DNode(T data) {
        this.data = data;
    }

    @Override
    public DNode<T> getPrevious() {
        return previous;
    }

    @Override
    public void setPrevious(DNode<T> previous) {
        this.previous = previous;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public DNode<T> getNext() {
        return next;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public void setNext(DNode<T> next) {
        this.next = next;
    }

}
