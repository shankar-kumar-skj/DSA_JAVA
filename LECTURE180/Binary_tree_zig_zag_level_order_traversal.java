package JAVA.SHASHCODE.LECTURE180;

import java.util.*;


// LEVEL ORDER TRAVERSAL => BFS
// TC => O(N)+O(REVERSE THE LIST) BUT IN CASE OF LINKED LIST 0(REVERSE THE LIST) ==O(1) So, we say that TC => O(N)
// SC => O(N)

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

public class Binary_tree_zig_zag_level_order_traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        if(root==null){
            return res;
        }

        // Level Order Traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> levelSubList=new LinkedList<>();
            while(size>0){
                // BFS
                TreeNode node=queue.poll();
                // odd case
                if(level%2!=0){
                    levelSubList.addFirst(node.val);
                }
                // even
                else{
                    levelSubList.add(node.val);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
            level++;
            res.add(levelSubList);
        }
        return res;
    }
}
