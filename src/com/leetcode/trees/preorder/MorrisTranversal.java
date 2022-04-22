package com.leetcode.trees.preorder;
import java.util.*;
/**https://leetcode.com/problems/binary-tree-preorder-traversal/solution/*/
class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
         this.right = right;
     }
}

class Solution {
    public List<Integer> morrisPreorderTraversal(TreeNode root) {
        /**Morris travesal on pre-order*/
        LinkedList<Integer> output= new LinkedList<>();
        TreeNode node=root;
        while(node != null){
            if(node.left==null){
                output.add(node.val);
                node=node.right;
            }
            else{
                TreeNode pred=node.left;
                while(pred.right != null && pred.right != node){
                    pred=pred.right;
                }
                if(pred.right==null){
                    output.add(node.val);
                    pred.right=node;
                    node=node.left;
                }
                else{
                    pred.right=null;
                    node=node.right;
                }
            }
        }
        return output;
    }
}
public class MorrisTranversal {
}
