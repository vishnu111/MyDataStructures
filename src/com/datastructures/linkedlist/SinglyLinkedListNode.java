package com.datastructures.linkedlist;

public class SinglyLinkedListNode<E> {
    E element;
    SinglyLinkedListNode<E> next;
    public SinglyLinkedListNode(E e, SinglyLinkedListNode<E> n){
        element=e;
        next=n;
    }
    public E getElement() {
        return element;
    }
    public SinglyLinkedListNode<E> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode<E> next) {
        this.next = next;
    }

}
