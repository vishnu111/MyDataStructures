package com.datastructures.stack;

import com.datastructures.linkedlist.SinglyLinkedList;

public class StackUsingSLinkedList<E> implements Stack<E> {
   private SinglyLinkedList<E> sll= new SinglyLinkedList<E>();
    public int size(){
       return sll.size();
    }
    public boolean isEmpty(){
        return sll.isEmpty();
    }
    public void push(E e){
        sll.addFirst(e);
    }
    public E pop(){
        return sll.removeFirst();
    }
    public E top(){
        return sll.first();
    }
    public static void main(String[] args){
        StackUsingSLinkedList<Integer> sua= new StackUsingSLinkedList<Integer>();
        sua.push(1);
        sua.push(2);
        System.out.println(sua.pop());
        sua.push(5);
        System.out.println(sua.pop());
        System.out.println(sua.size());
        System.out.println(sua.top());
        System.out.println(sua.isEmpty());
    }
}
