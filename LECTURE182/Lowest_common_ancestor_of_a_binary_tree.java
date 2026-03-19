package JAVA.SHASHCODE.LECTURE182;

// import java.util.*;

// // STEPS FOR LCA (LOWEST COMMON ANCESTOR)
// 1. Apply DFS
// 2. If you find any one of the target node, return the node itself
// 3. If any one of the subtree return a NON-NULL Node, the return the NON-NULL Node
// 4. If both the subtree returns the NON-NULL value, then it is LCA, return the Node itself.
// 5. If both the subtree returns NULL then return NULL.

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

public class Lowest_common_ancestor_of_a_binary_tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode leftChild = lowestCommonAncestor(root.left, p, q);
        TreeNode rightChild = lowestCommonAncestor(root.right, p, q);

        if(leftChild==null){
            return rightChild;
        }
        else if(rightChild==null){
            return leftChild;
        }
        else{
            return root;
        }
    }
}
