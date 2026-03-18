package JAVA.SHASHCODE.LECTURE179;

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

// Preorder traversal
// O(N + 3 log(N)) == O(N)
// Stack => Recursion (DFS) + STACK (Reverse right -> up side)

public class Boundary_traversal_of_binary_tree {
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        // insert the root
        if(!isLeaf(root)){
            res.add(root.data);
        }
        // insert left boundary
        insertLeftBoundary(res, root);
        // leaf
        insertLeafNode(res, root);
        // insert right boundary
        insertRightBoundary(res, root);

        return res;
    }
    public void insertLeftBoundary(ArrayList<Integer> res, Node root){
        Node leftNode=root.left;
        while(leftNode!=null){
            if(isLeaf(leftNode)){
                break;
            }
            res.add(leftNode.data);
            if(leftNode.left!=null){
                leftNode = leftNode.left;
            }
            else{
                leftNode = leftNode.right;
            }
        }
    }
    public void insertRightBoundary(ArrayList<Integer> res, Node root){
        Node rightNode=root.right;
        Stack<Integer> stack=new Stack<>();
        while(rightNode!=null){
            if(isLeaf(rightNode)){
                break;
            }
            // res.add(rightNode.data);
            stack.push(rightNode.data);
            if(rightNode.right!=null){
                rightNode = rightNode.right;
            }
            else{
                rightNode = rightNode.left;
            }
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
    }

    public void insertLeafNode(ArrayList<Integer> res, Node root){
        if(root==null){
            return;
        }
        if(isLeaf(root)){
            res.add(root.data);
        }
        insertLeafNode(res, root.left);
        insertLeafNode(res, root.right);
    }

    public boolean isLeaf(Node node){
        return (node.left==null && node.right==null);
    }

}
