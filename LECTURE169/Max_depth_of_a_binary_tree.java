package JAVA.SHASHCODE.LECTURE169;

import java.util.*;


// Maxx Depth = Height of a Binary Tree 
// DFS => HEIGHT
// BFS (Level Order Traversal) => Level + 1

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Max_depth_of_a_binary_tree {
    // public int maxDepth(TreeNode root){
    //     if(root==null){
    //         return 0;
    //     }
    //     Queue<TreeNode> queue =new LinkedList<>();
    //     queue.offer(root);
    //     int level=0;
    //     while(!queue.isEmpty()){
    //         int size = queue.size();

    //         // Level wise traversal
    //         while(size>0){
    //             TreeNode node=queue.poll();
    //             size--;
    //             if(node.left!=null){
    //                 queue.offer(node.left);
    //             }
    //             if(node.right!=null){
    //                 queue.offer(node.right);
    //             }
    //         }
    //         if(!queue.isEmpty()){
    //             level++;
    //         } 
    //     }
    //     return (level+1);
    // }


    // // height using DFS Traversal

    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        // left height
        int lh=maxDepth(root.left);

        // right height
        int rh=maxDepth(root.right);

        return (1+Math.max(lh,rh));
    }
}
