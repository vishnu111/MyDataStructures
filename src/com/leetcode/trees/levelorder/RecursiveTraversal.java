package com.leetcode.trees.levelorder;
import java.util.*;
/**link*/
/**https://leetcode.com/problems/binary-tree-level-order-traversal/*/
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
    List<List<Integer>> output = new ArrayList<>();
    private void helper(RecursiveTreeNode node, int level){
        if(output.size() == level)
            output.add(new ArrayList<Integer>());
        output.get(level).add(node.val);
        if(node.left != null){
            System.out.println("At the first if");
            System.out.println(output);
            helper(node.left, level+1);
        }
        if(node.right != null){
            System.out.println("At the second if");
            System.out.println(output);
            helper(node.right, level+1);
        }
    }
    public List<List<Integer>> levelOrder(RecursiveTreeNode root) {
        if(root == null)
            return output;
        helper(root, 0);
        return output;
    }
}
public class RecursiveTraversal {
}
