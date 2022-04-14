package com.datastructures.linkedlist;

public class SinglyLinkedList<E> {

    SinglyLinkedListNode<E> head=null;
    SinglyLinkedListNode<E> tail=null;
    int size=0;
    public SinglyLinkedList(){
    }

    public int size(){
      return size;
    }
    public boolean isEmpty(){
         return size==0;
    }
    public E first(){
     if(isEmpty())return null;
     return head.getElement();
    }
    public E last(){
     if(isEmpty())return null;
     return tail.getElement();
    }
    public void addFirst(E e){
     head= new SinglyLinkedListNode<>(e,head);
     if(size ==0)
         tail=head;
     size++;
    }
    public void addLast(E e){
        SinglyLinkedListNode<E> newone= new SinglyLinkedListNode<E>(e,null);
        if(isEmpty())
            head=newone;
        else
            tail.setNext(newone);
        tail=newone;
        size++;
    }
    public E removeFirst(){
        if(isEmpty())return null;
        E out = head.getElement();
        head=head.getNext();
        size--;
        if(size==0)
            tail=head;
        return out;
    }
}
