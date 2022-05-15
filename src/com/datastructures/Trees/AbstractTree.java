package com.datastructures.Trees;
import java.util.*;
import com.datastructures.LinkedPositionalList.Position;
import com.datastructures.queue.Queue;
import com.datastructures.queue.*;
public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p){
        return numChildren(p)>0;
    }
    public boolean isExternal(Position<E> p){
        return numChildren(p)==0;
    }
    public boolean isRoot(Position<E> p){
        return p==root();
    }
    public boolean isEmpty(){
        return size()==0;
    }
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
        snapshot.add(p);
        for(Position<E> c:children(p))
            preorderSubtree(c,snapshot);
    }
    public Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            preorderSubtree(root(), snapshot);
        return snapshot;
    }
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
        for(Position<E> c:children(p))
            postorderSubtree(c,snapshot);
        snapshot.add(p);
    }
    public Iterable<Position<E>> postorder(){
        List<Position<E>> snapshot= new ArrayList<>();
        if(!isEmpty())
            postorderSubtree(root(), snapshot);
        return snapshot;
    }
    public Iterable<Position<E>> breadthfirst(){
        List<Position<E>> snapshot= new ArrayList<>();
        if(!isEmpty()){
            Queue<Position<E>> que= new QueueUsingSLinkedList<>();
            que.enqueue(root());
            while(!que.isEmpty()){
                Position<E> p= que.dequeue();
                snapshot.add(p);
                for(Position<E> c: children(p))
                    que.enqueue(c);
            }
        }
        return snapshot;
    }
}
