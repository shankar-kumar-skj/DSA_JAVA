package JAVA.SHASHCODE.LECTURE166;

import java.util.*;

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

public class Iteration_inorder_traversal {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack =new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            // move to the left
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            // print the root
            node= stack.pop();
            res.add(node.val);
            // move to the right
            node= node.right;
        }
        return res;
    }
}
