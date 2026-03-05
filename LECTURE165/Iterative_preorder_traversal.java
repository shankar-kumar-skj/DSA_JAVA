package JAVA.SHASHCODE.LECTURE165;

import java.util.*;

// Iterative_preorder_traversal => using stack 

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

public class Iterative_preorder_traversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();

        if(root==null){
            return res;
        }

        Stack<TreeNode> stack =new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return res;
    }
}
