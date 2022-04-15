package com.datastructures.queue;

public class QueueUsingArrays<E> implements Queue<E> {
    public static final int CAPACITY=100;
    E[] data;
    int sz=0, f=0;
    public QueueUsingArrays(){
        this(CAPACITY);
    }
    public QueueUsingArrays(int Cap){
       data=(E[]) new Object[Cap];
    }
    public int size(){
        return sz;
    }
    public boolean isEmpty(){
        return sz==0;
    }
    public void enqueue(E e){
        if(size()==data.length)throw new IllegalStateException("Queue is full");
        int point=(f+sz)%data.length;
        data[point]=e;
        sz++;
    }
    public E dequeue(){
        if(isEmpty())return null;
        E fi=data[f];
        data[f]=null;
        f=(f+1)%data.length;
        sz--;
        return fi;
    }
    public E first(){
        if(isEmpty())return null;
        return data[f];
    }
    public static void main(String[] args){
        QueueUsingArrays<Integer> qua= new QueueUsingArrays<Integer>(5);
        qua.enqueue(1);
        qua.enqueue(2);
        qua.enqueue(3);
        qua.enqueue(4);
        System.out.println(qua.size());
        System.out.println(qua.first());
        System.out.println(qua.dequeue());
        System.out.println(qua.first());
    }
}
