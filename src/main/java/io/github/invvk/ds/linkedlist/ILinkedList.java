package io.github.invvk.ds.linkedlist;

import java.util.Objects;
import java.util.function.Consumer;

public interface ILinkedList<T, N extends INode<T, N>> {

    boolean isEmpty();

    N getNodeAt(int pos);

    void insertToHead(T value);

    void insertToTail(T value);

    void insertToPos(int pos, T value);

    T deleteFromHead();

    T deleteFromTail();

    T deleteFromPos(int pos);

    void print();

    N getHead();

    N getTail();

    void setHead(N head);

    void setTail(N tail);

    int size();

    default void forEach(Consumer<? super N> action) {
        Objects.requireNonNull(action);
        N node = getHead();
        while (node != null) {
            action.accept(node);
            node = node.getNext();
        }
    }
}
