package com.leetcode.trees.postorder;
import java.util.*;

/**https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/*/
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
    LinkedList<Integer> output = new LinkedList<>();
    public List<Integer> postorderTraversal(RecursiveTreeNode root) {
        if(root == null)
            return output;

        if(root.left != null){
            postorderTraversal(root.left);
        }
        if(root.right != null){
            postorderTraversal(root.right);
        }
        output.add(root.val);

        return output;

    }
}
public class RecursiveTraversal {
}
