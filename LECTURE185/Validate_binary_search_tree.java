package JAVA.SHASHCODE.LECTURE185;

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

// Left 
//     min -> parent min
//     max -> parent val

// Right 
//     min -> parent val
//     max -> parent max

// TC => O(N)
// TC => O(H)

public class Validate_binary_search_tree {
    public boolean isValidBST(TreeNode root) {
        return validate(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean validate(TreeNode root, int min, int max){
        if(root==null){
            return true;
        }
        if(root.val <=min || root.val>=max){
            return false;
        }
        boolean leftSubtree=validate(root.left, min, root.val);
        boolean rightSubtree=validate(root.right,  root.val,max);
        return (leftSubtree && rightSubtree);
    }
}
