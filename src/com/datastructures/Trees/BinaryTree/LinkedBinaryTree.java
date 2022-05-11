package com.datastructures.Trees.BinaryTree;

import com.datastructures.LinkedPositionalList.Position;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    protected static class Node<E> implements Position<E>{
        private E element;
        private Node<E> left;
        private Node<E> right;
        private Node<E> parent;
        public Node(E ele, Node<E> parentOne, Node<E> leftChild, Node<E> rightChild){
            element=ele;
            parent=parentOne;
            left=leftChild;
            right=rightChild;
        }
        @Override
        public E getElement() {
            return element;
        }
        public void setElement(E element) {
            this.element = element;
        }
        public Node<E> getLeft() {
            return left;
        }
        public void setLeft(Node<E> left) {
            this.left = left;
        }
        public Node<E> getRight() {
            return right;
        }
        public void setRight(Node<E> right) {
            this.right = right;
        }
        public Node<E> getParent() {
            return parent;
        }
        public void setParent(Node<E> parent) {
            this.parent = parent;
        }
    }
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
        return new Node<E>(e,parent,left,right);
    }
    protected Node<E> root=null;
    private int size=0;
    public LinkedBinaryTree(){}
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Not a valid position type");
        Node<E> node= (Node<E>) p;
        if(node==node.getParent())
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }
    public int size(){
        return size;
    }
    public Position<E> root(){
        return root;
    }
    public Position<E> left(Position<E> p) throws IllegalArgumentException{
        Node<E> node=validate(p);
        return node.getLeft();
    }
    public Position<E> right(Position<E> p) throws IllegalArgumentException{
        Node<E> node=validate(p);
        return node.getRight();
    }
    public Position<E> parent(Position<E> p) throws IllegalArgumentException{
        Node<E> node=validate(p);
        return node.getParent();
    }
    public Position<E> addRoot(E e) throws IllegalArgumentException{

    }
}
