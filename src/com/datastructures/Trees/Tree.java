package com.datastructures.Trees;
import com.datastructures.LinkedPositionalList.Position;

import java.util.Iterator;
/*The tree interface has all the methods that are possible in a generic tree*/
public interface Tree<E> extends Iterable<E> {
    Position<E> root();
    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
    int numChildren(Position<E> p) throws IllegalArgumentException;
    boolean isInternal(Position<E> p) throws IllegalArgumentException;
    boolean isExternal(Position<E> p) throws IllegalArgumentException;
    boolean isRoot(Position<E> p) throws IllegalArgumentException;
    boolean isEmpty();
    int size();
    Iterator<E> iterator();
    Iterable<Position<E>> positions();
}
