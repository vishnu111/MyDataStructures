package com.datastructures.stack;

public class StackUsingArrays<E> implements Stack<E>{
    public static final int CAPACITY=100;
    E[] data;
    int t=-1;
    public StackUsingArrays(){
        this(CAPACITY);
    }
    public StackUsingArrays(int CAP){
        data= (E[]) new Object[CAP];
    }

    @Override
    public E top() {
        if(isEmpty()) return null;
         return data[t];
    }
    public int size(){
        return t+1;
    }
    public boolean isEmpty(){
        return t==-1;
    }
    public void push(E e){
        if(size()==data.length)throw new IllegalStateException("Stack is full");
        data[++t]=e;
    }
    public E pop(){
        if(isEmpty())return null;
        E x=data[t];
        data[t]=null;
        t--;
        return x;
    }
    public static void main(String[] args) {
        Stack<Integer> sua= new StackUsingArrays<Integer>(5);
        sua.push(1);
        sua.push(2);
        System.out.println(sua.pop());
        sua.push(4);
        System.out.println(sua.pop());
        System.out.println(sua.size());
        System.out.println(sua.top());
        System.out.println(sua.isEmpty());
    }
}
