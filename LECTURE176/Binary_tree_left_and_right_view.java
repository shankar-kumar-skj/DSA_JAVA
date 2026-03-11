package JAVA.SHASHCODE.LECTURE176;

import java.util.*;

// TC => O(N)
// SC => O(LEVEL HAS MAXIMUM SIZE)

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

class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class Binary_tree_left_and_right_view {

    // Right View in Binary Tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        

        // BFS
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                size--;
                if(size==0){
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    // // Left View in Binary Tree
    
    // public ArrayList<Integer> leftView(Node root) {
    //     // code here
    //     ArrayList<Integer> res=new ArrayList<>();
    //     if(root==null){
    //         return res;
    //     }
    //     Queue<Node> queue=new LinkedList<>();
    //     queue.offer(root);

    //     // BFS
    //     while(!queue.isEmpty()){
    //         int size=queue.size();
    //         if(size>0){
    //             Node node=queue.peek();
    //             res.add(node.data);
    //         }
    //         while(size>0){
    //             Node node=queue.poll();
    //             if(node.left!=null){
    //                 queue.offer(node.left);
    //             }
    //             if(node.right!=null){
    //                 queue.offer(node.right);
    //             }
    //             size--;
    //         }
    //     }
    //     return res;
    // }


    // // method 2nd :
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);

        // BFS
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node node=queue.poll();
                if(i==0){
                    res.add(node.data);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
