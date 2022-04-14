package com.datastructures;

public interface Stack<E> {
    E pop();
    void push(E e);
    boolean isEmpty();
    E top();
    int size();

}
