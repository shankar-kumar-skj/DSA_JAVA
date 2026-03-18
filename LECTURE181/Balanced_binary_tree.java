package JAVA.SHASHCODE.LECTURE181;

// import java.util.*;

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

// DFS => POST ORDER (LEFT RIGHT ROOT)
// TC => O(N)
// SC => O(N)

public class Balanced_binary_tree {
    public boolean isBalanced(TreeNode root) {
        int height=getHeight(root);
        return (height!=-1);
    }
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }

        // post order traversal
        int leftSubTreeHeight=getHeight(root.left);
        int rightSubTreeHeight=getHeight(root.right);
        if(leftSubTreeHeight == -1 || rightSubTreeHeight == -1){
            return -1;
        }
        if(Math.abs(leftSubTreeHeight-rightSubTreeHeight)>1){
            return -1;
        }
        return 1+Math.max(leftSubTreeHeight,rightSubTreeHeight);
    }
}
