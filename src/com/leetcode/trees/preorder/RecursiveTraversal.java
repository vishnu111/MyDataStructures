package com.leetcode.trees.preorder;
import java.util.*;
class RecursiveTreeNode {
    int val;
    RecursiveTreeNode left;
    RecursiveTreeNode right;
    RecursiveTreeNode() {}
    RecursiveTreeNode(int val) { this.val = val; }
    RecursiveTreeNode(int val, RecursiveTreeNode left, RecursiveTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class RecursiveSolution {
    LinkedList<Integer> output= new LinkedList<>();
    public List<Integer> recursivePreorderTraversal(RecursiveTreeNode root) {
        if(root == null)
            return output;
        output.add(root.val);
        if(root.left != null)
            recursivePreorderTraversal(root.left);
        if(root.right!=null)
            recursivePreorderTraversal(root.right);
        return output;
    }

}
public class RecursiveTraversal {
}
