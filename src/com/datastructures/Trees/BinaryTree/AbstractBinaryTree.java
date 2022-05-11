package com.datastructures.Trees.BinaryTree;

import com.datastructures.LinkedPositionalList.Position;
import com.datastructures.Trees.AbstractTree;

import java.util.ArrayList;
import java.util.*;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    public Position<E> sibling(Position<E> p){
        Position<E> parent = parent(p);
        if(parent == null)
            return null;
        if(left(parent) == p)
            return right(parent);
        else
            return left(parent);
    }
    public int numChildren(Position<E> p){
        int count=0;
        if(right(p)!=null)
            count++;
        if(left(p)!=null)
            count++;
        return count;
    }
    public Iterable<Position<E>> children(Position<E> p){
        List<Position<E>> snapshot = new ArrayList<>(2);
        if(left(p)!=null)
            snapshot.add(left(p));
        if(right(p)!=null)
            snapshot.add(right(p));
        return snapshot;
    }
}
