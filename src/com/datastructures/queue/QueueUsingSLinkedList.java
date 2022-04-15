package com.datastructures.queue;

import com.datastructures.linkedlist.SinglyLinkedList;

public class QueueUsingSLinkedList<E> implements Queue<E> {
    private SinglyLinkedList<E> sll= new SinglyLinkedList<E>();
    public int size(){
        return sll.size();
    }
    public boolean isEmpty(){
        return sll.isEmpty();
    }
    public void enqueue(E e){
        sll.addLast(e);
    }
    public E dequeue(){
        return sll.removeFirst();
    }
    public E first(){
        return sll.first();
    }
    public static void main(String[] args){
        QueueUsingSLinkedList<Integer> qua= new QueueUsingSLinkedList<>();
        qua.enqueue(1);
        qua.enqueue(2);
        qua.enqueue(2);
        qua.enqueue(3);
        qua.enqueue(5);
        System.out.println(qua.size());
        System.out.println(qua.first());
        System.out.println(qua.dequeue());
        System.out.println(qua.first());
    }
}
