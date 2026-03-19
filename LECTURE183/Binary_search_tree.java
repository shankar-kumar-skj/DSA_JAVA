package JAVA.SHASHCODE.LECTURE183;

// import java.util.*;

// Binary Tree => rules => binary search tree
// RULES -> LST < Root < RST 

// IF DUPLICATE :-
// RULES -> LST <= Root < RST 
//              OR 
// RULES -> LST < Root <= RST 

// Construct a Binary Search Tree (left to right array traveral according to the rule)

// TC => O(Height)
// Skewed Right OR Left Binary Search Tree => O(N)
// Complete Binary tree => O(log N) 


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

public class Binary_search_tree {

    // // Insert into Binary Search Tree => leetcode 701

    // // Method -> 1st : Iterative Approach
    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     if(root==null){
    //         root=new TreeNode(val);
    //         return root;
    //     }

    //     // find the position and insert
    //     TreeNode temp=root;
    //     while(temp!=null){
    //         if(val<temp.val){
    //             // left subtree
    //             if(temp.left==null){
    //                 temp.left = new TreeNode(val);
    //                 break;
    //             }
    //             else{
    //                 temp=temp.left;
    //             }
    //         }
    //         else{
    //             // right subtree
    //             if(temp.right==null){
    //                 temp.right = new TreeNode(val);
    //                 break;
    //             }
    //             else{
    //                 temp=temp.right;
    //             }
    //         }
    //     }
    //     return root;
    // }

// TC => O(N)
// SC => O(N)
    // Method -> 2nd : Recursive Approach

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            root=new TreeNode(val);
            return root;
        }
        if(val<root.val){
            root.left = insertIntoBST(root.left, val);
        }
        else{
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
