package io.github.invvk.ds.linkedlist;

public interface INode<T, N extends INode<T,N>> {
    T getData();

    N getNext();

    void setData(T data);

    void setNext(N next);
}
