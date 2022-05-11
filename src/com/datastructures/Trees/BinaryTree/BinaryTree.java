package com.datastructures.Trees.BinaryTree;

import com.datastructures.LinkedPositionalList.Position;
import com.datastructures.Trees.Tree;

public interface BinaryTree<E> extends Tree<E> {
 Position<E> left(Position<E> p) throws IllegalArgumentException;
 Position<E> right(Position<E> p) throws IllegalArgumentException;
 Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
