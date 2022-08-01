package io.github.invvk.ds.linkedlist.singly;

import io.github.invvk.ds.linkedlist.INode;

/**
 * Single Node Class
 * @param <T> represents data.
 */
public class SNode<T> implements INode<T, SNode<T>> {

    private T data;
    private SNode<T> next;

    public SNode() {}
    public SNode(T data) {
        this.data = data;
    }

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public SNode<T> getNext() {
        return next;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public void setNext(SNode<T> next) {
        this.next = next;
    }

}
