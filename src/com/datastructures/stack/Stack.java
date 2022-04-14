package com.datastructures.stack;

public interface Stack<E> {
    E pop();
    void push(E e);
    boolean isEmpty();
    E top();
    int size();

}
