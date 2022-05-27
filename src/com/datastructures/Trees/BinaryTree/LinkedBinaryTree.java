package com.datastructures.Trees.BinaryTree;

import com.datastructures.LinkedPositionalList.Position;
import com.datastructures.Trees.BinaryTree.AbstractBinaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    public Position<E> addRoot(E e) throws IllegalStateException{
       if(!isEmpty()) throw new IllegalStateException("The tree is not empty");
       root=createNode(e,null,null,null);
       size=1;
       return root;
    }
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if(parent.getLeft()!=null)
            throw new IllegalArgumentException("p already have the left child");
        Node<E> child = createNode(e,parent,null,null);
        parent.setLeft(child);
        size++;
        return child;
    }
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if(parent.getRight() != null) throw new IllegalArgumentException("p already have the right child");
        Node<E> child=createNode(e,parent,null,null);
        parent.setRight(child);
        size++;
        return child;
    }
    public E set(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node= validate(p);
        E temp=node.getElement();
        node.setElement(e);
        return temp;
    }
    public void attach(Position<E> p, LinkedBinaryTree<E> T1, LinkedBinaryTree<E> T2) throws IllegalArgumentException{
        Node<E> node= validate(p);
        size=size+T1.size()+T2.size();
        if(isInternal(p)) throw new IllegalArgumentException("p must be an external or leaf node");
        if(!T1.isEmpty()){
            T1.root.setParent(node);
            node.setLeft(T1.root);
            T1.root=null;
            T1.size=0;
        }
        if(!T2.isEmpty()){
            T2.root.setParent(node);
            node.setRight(T2.root);
            T2.root=null;
            T2.size=0;
        }
    }
    public E remove(Position<E> p) throws IllegalArgumentException{
        Node<E> node= validate(p);
        if(numChildren(node)==2) throw new IllegalArgumentException("p should have only one children for this operation");
        Node<E> child=(node.getRight()!=null ? node.getRight() : node.getLeft());
        if(child != null)
            child.setParent(node.getParent());
        if(node == root)
            root=child;
        else{
            Node<E> parent=node.getParent();
            if(parent.getLeft() == node)
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E temp=node.getElement();
        node.setElement(null);
        node.setRight(null);
        node.setLeft(null);
        node.setParent(node);
        return temp;
    }
    private class ElementIterator implements Iterator<E>{
        Iterator<Position<E>> posIterator = positions().iterator();
        public boolean hasNext(){
            return posIterator.hasNext();
        }
        public E next(){
            return posIterator.next().getElement();
        }
        public void remove(){
            posIterator.remove();
        }
    }
    public Iterator<E> iterator(){
        return new ElementIterator();
    }
    public Iterable<Position<E>> positions(){
        return preorder();
    }
}
