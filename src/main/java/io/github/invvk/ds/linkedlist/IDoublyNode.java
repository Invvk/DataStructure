package io.github.invvk.ds.linkedlist;

public interface IDoublyNode<T, N extends IDoublyNode<T, N>> extends INode<T, N> {

     N getPrevious();

    void setPrevious(N previous);

}
