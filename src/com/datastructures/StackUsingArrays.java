package com.datastructures;

public class SingleLinkedList<E> implements Stack<E>{
    public static final int CAPACITY=100;
    E[] e;
    public SingleLinkedList(){
        e=(E) new Object()[CAPACITY];
    }

    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
