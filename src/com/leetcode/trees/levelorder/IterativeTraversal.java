package com.leetcode.trees.levelorder;

import java.util.*;
/**https://leetcode.com/problems/binary-tree-level-order-traversal/*/
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

    public List<List<Integer>> levelOrder(IterativeTreeNode root) {

        List<IterativeTreeNode> iter= new ArrayList<>();
        List<List<Integer>> out = new ArrayList<>();
        if(root == null)
            return out;
        IterativeTreeNode node= root;
        iter.add(node);
        int level=0;
        while(!(iter.isEmpty())){
            out.add(new ArrayList<Integer>());
            int length=iter.size();
            for(int i=0; i<length; i++ ){
                if(iter.get(0).left != null){
                    iter.add(iter.get(0).left);
                }
                if(iter.get(0).right != null){
                    iter.add(iter.get(0).right);
                }
                out.get(level).add(iter.get(0).val);
                iter.remove(0);
            }
            level++;

        }
        return out;
    }
}
public class IterativeTraversal {
}
