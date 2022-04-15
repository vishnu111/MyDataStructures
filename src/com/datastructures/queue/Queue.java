package com.datastructures.queue;

public interface Queue<E> {
    /**returns the no. of elements in the queue*/
    int size();

    /**returns true, if queue is empty*/
    boolean isEmpty();

    /**adds the elements to the end of the list*/
    void enqueue(E e);

    /**returns the first element in the queue, does not remove, and returns null if queue is empty*/
    E first();

    /**removes and returns the first elements in the queue, return null if empty*/
    E dequeue();
}
