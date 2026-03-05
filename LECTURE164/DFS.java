package JAVA.SHASHCODE.LECTURE164;

import java.util.*;

// DFS IN TREE => 3
// 1. Preorder => Root -> Left -> Right
// 2. Inorder => Left -> Root -> Right
// 3. Postorder => Left -> Right -> Root

public class DFS {

// // PreOrder Traversal

// class Node {
//     int data;
//     Node left;
//     Node right;

//     Node(int data) {
//         this.data = data;
//         left = null;
//         right = null;
//     }
// }

// class Solution {
//     public ArrayList<Integer> preOrder(Node root) {
//         //  code here
        
//         ArrayList<Integer> res=new ArrayList<>();
//         preorderTraversal(root,res);
//         return res;
//     }

//     public void preorderTraversal(Node root,ArrayList<Integer> res){
//         if (root==null){//             return;
//         }
//         // System.out.println(root.data);
//         res.add(root.data);
//         preorderTraversal(root.left,res);
//         preorderTraversal(root.right,res);

//     }
// }



// // InOrder Traversal 


// class Node {
//     int data;
//     Node left, right;
//     Node(int item){
//         data = item;
//         left = right = null;
//     }
// }

// class Solution {
//     public ArrayList<Integer> inOrder(Node root) {
//         //  code here
        
//         ArrayList<Integer> res=new ArrayList<>();
//         inOrderTraversal(root,res);
//         return res;
//     }

//     public void inOrderTraversal(Node root,ArrayList<Integer> res){
//         if (root==null){
//             return;
//         }
//         // System.out.println(root.data);
//         inOrderTraversal(root.left,res);
//         res.add(root.data);
//         inOrderTraversal(root.right,res);

//     }
// }



// // PostOrder Traversal

// class Node {
//     int data;
//     Node left, right;
//     Node(int val){
//         data = val;
//         left = right = null;
//     }
// }


// class Solution {
//     public ArrayList<Integer> postOrder(Node root) {
//         //  code here
        
//         ArrayList<Integer> res=new ArrayList<>();
//         postOrderTraversal(root,res);
//         return res;
//     }

//     public void postOrderTraversal(Node root,ArrayList<Integer> res){
//         if (root==null){
//             return;
//         }
//         // System.out.println(root.data);
//         postOrderTraversal(root.left,res);
//         postOrderTraversal(root.right,res);
//         res.add(root.data);

//     }
// }

}