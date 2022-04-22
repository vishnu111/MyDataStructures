package com.leetcode.trees;
import java.util.*;
/**https://leetcode.com/problems/binary-tree-preorder-traversal/solution/*/
class IterativeTreeNode {
      int val;
      IterativeTreeNode left;
     IterativeTreeNode right;
      IterativeTreeNode() {}
     IterativeTreeNode(int val) { this.val = val; }
     IterativeTreeNode(int val, IterativeTreeNode left, IterativeTreeNode right) {
          this.val = val;
         this.left = left;
         this.right = right;
     }
  }
class IterativeSolution {
    public List<Integer> preorderTraversal(IterativeTreeNode root) {
        /**Iterative travesal on pre-order*/
        LinkedList<Integer> output = new LinkedList<>();
        LinkedList<IterativeTreeNode> stack = new LinkedList<>();
        if(root==null)
            return output;
        stack.add(root);
        while(!(stack.isEmpty())){
            IterativeTreeNode node=stack.pollLast();
            output.add(node.val);
            if(node.right != null)
                stack.add(node.right);
            if(node.left != null)
                stack.add(node.left);
        }
        return output;
    }
}
public class IterativePreOrderTraversal {
}
