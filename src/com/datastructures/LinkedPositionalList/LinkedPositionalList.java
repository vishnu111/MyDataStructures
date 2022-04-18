package com.datastructures.LinkedPositionalList;

public class LinkedPositionalList<E> implements PositionalList<E> {
    private static class Node<E> implements Position<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n){
            element=e;
            prev=p;
            next=n;
        }
        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
        public E getElement() throws IllegalStateException{
            if(next == null)throw new IllegalStateException("Position is no longer valid");
            return element;
        }
        public void setElement(E e){
            element=e;
        }
    }
    private Node<E> header;
    private Node<E> trailer;
    private int size=0;
    public LinkedPositionalList(){
        header= new Node<E>(null, null, null);
        trailer=new Node<E>(null, header, null);
        header.setNext(trailer);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    /**returns the given node as position or (null, if it is sentinal)*/
    private Position<E> position(Node<E> node){
        if(node==header || node==trailer) return null;
        return node;
    }
    public Position<E> first(){
      return(position(header.getNext()));
    }
    public Position<E> last(){
        return(position(header.getPrev()));
    }
    private Node<E> validate(Position<E> p){
        if(!(p instanceof Node)) throw new IllegalArgumentException("Invalid position p");
        Node<E> node = (Node<E>) p;
        if(node.getNext()==null) throw new IllegalArgumentException("P is no longer in the list");
        return node;
    }
    public Position<E> before(Position<E> p)throws IllegalStateException{
        Node<E> node= validate(p);
        return position(node.getPrev());
    }
    public Position<E> after(Position<E> p)throws IllegalStateException{
        Node<E> node= validate(p);
        return position(node.getNext());
    }
    public Position<E> addBetween(E e, Node<E> prev, Node<E> next){
        Node<E> node= new Node<E>(e,prev,next);
        prev.setNext(node);
        next.setPrev(node);
        size++;
        return node;
        /**check if this works too
        node.setNext(next);
        node.setPrev(prev);*/
    }
    public Position<E> addFirst(E e){
       return addBetween(e,header,header.getNext());
    }
    public Position<E> addLast(E e){
        return addBetween(e,trailer.getPrev(), trailer);
    }
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(),node);
    }
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return addBetween(e, node,node.getNext());
    }
    public E set(Position<E> p, E e) throws  IllegalArgumentException{
        Node<E> node= validate(p);
        E out = node.getElement();
        node.setElement(e);
        return out;
    }
    public E remove(Position<E> p) throws IllegalStateException{
        Node<E> node = validate(p);
        Node<E> before= node.getPrev();
        Node<E> after=node.getNext();
        before.setNext(after);
        after.setPrev(before);
        size--;
        E out=node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);
        return out;
    }
}
