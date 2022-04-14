package com.datastructures.linkedlist;
public class SinglyLinkedListMain {
    public static void main(String[] args){
        SinglyLinkedList<Integer> sll= new SinglyLinkedList<Integer>();
        sll.addFirst(2);
        sll.addFirst(3);
        sll.addLast(4);
        System.out.println(sll.size());
        System.out.println(sll.last());
        System.out.println(sll.size());
        System.out.println(sll.removeFirst());
        System.out.println(sll.size());
    }
}
