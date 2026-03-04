package JAVA.SHASHCODE.LECTURE162;

import java.util.*;

// BFS => BREADTH FIRST SEARCH => TREE DATA STRUCTURE KNIWN AS LEVEL ORDER TRAVE  RSAL

// non linear data structure => traversal => BFS & DFS

// => BFS => DIRECT CONNECTED FIRST PROCESS THEN => DIRECTLY DIRECTLY CONNECTED PROCESS => AND SOON ON ...

// D <- C <- A ->B
//           |
//           -> E -> F

// A C B E D F

//      20 => ROOT NODE
//     /  \
//    5    7
//   / \    \
//  9  8     10
//    /
//   15

//  BFS => 20, 5,7,9,8,10,15
// BFS => IN TREE DATA STRUCTURE CASE => LEVEL ORDER TRAVERSAL => IN QUEUE DATA STRUCTURE.

public class Tree_traversal {
    class TreeNode<E>{
        E data;
        TreeNode left;
        TreeNode right;
        public TreeNode(E data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static void main(String[] args) {
        
    }
    public ArrayList<Integer> BFS(TreeNode <Integer>root){
        ArrayList<Integer> res=new ArrayList<>();
        Queue <TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode<Integer> node = queue.poll();
            res.add(node.data);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return res;
    }
}



// /*
// class Node {
//     int data;
//     Node left, right;

//     Node(int item) {
//         data = item;
//         left = right = null;
//     }
// }
// */
// class Solution {
//     public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
//         // code here
//         ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        
//         if(root ==null) return result;
        
//         Queue <Node> queue =new LinkedList<>();
//         queue.offer(root);
        
//         while(!queue.isEmpty()){
//             int size = queue.size();  // Number of nodes at current level
//             ArrayList<Integer> level = new ArrayList<>();
            
//             for(int i=0;i<size;i++){
//             Node node = queue.poll();
//             level.add(node.data);
//             if(node.left!=null){
//                 queue.offer(node.left);
//             }
//             if(node.right!=null){
//                 queue.offer(node.right);
//             }
//         }
//         result.add(level);
//     }
//         return result;
//     }
// }
