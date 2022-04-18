package com.datastructures.LinkedPositionalList;

public interface PositionalList<E> {

    /**Returns the no. of elements in the list*/
    int size();

    /**Returns is the list it empty or not*/
    boolean isEmpty();

    /**Returns the first position in the list, or null if empty*/
    Position<E> first();

    /**Returns the last position in the list, or null if empty*/
    Position<E> last();

    /**Returns the position just before the position p, or null if p is first position*/
    Position<E> before(Position<E> p) throws IllegalStateException;

    /**Returns the position just after the position p, or null if p is last position*/
    Position<E> after(Position<E> p) throws IllegalStateException;

    /**inserts the element e at first and returns it's position*/
    Position<E> addFirst(E e);

    /**inserts the element e at the end and returns it's position*/
    Position<E> addLast(E e);

    /**inserts element e just before position p and returns it's new position*/
    Position<E> addBefore(Position<E> p, E e) throws IllegalStateException;

    /**inserts element e just after position p and returns it's new position*/
    Position<E> addAfter(Position<E> p, E e) throws IllegalStateException;

    /**replaces the element at position p with e and returns the replaces position*/
    E set(Position<E> p, E e) throws IllegalStateException;

    /**removes the element at position p and return it*/
    E remove(Position<E> p) throws IllegalStateException;
}
