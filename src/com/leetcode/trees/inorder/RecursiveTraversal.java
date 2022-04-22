package com.leetcode.trees.inorder;
import java.util.*;
/**https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/929/*/
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

class Solution {
    LinkedList<Integer> output = new LinkedList<>();
    public List<Integer> inorderTraversal(RecursiveTreeNode root) {
        if(root==null)
            return output;
        if(root.left != null){
            inorderTraversal(root.left);
        }
        output.add(root.val);
        if(root.right != null){
            inorderTraversal(root.right);
        }
        return output;
    }
}
public class RecursiveTraversal {
}
