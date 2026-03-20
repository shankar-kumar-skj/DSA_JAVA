package JAVA.SHASHCODE.LECTURE189;

import java.util.Stack;

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

public class Binary_search_tree_iteration {
    Stack<TreeNode> stack;

    public Binary_search_tree_iteration(TreeNode root) {
        stack =new Stack<>();
        // insert left boundary
        TreeNode node=root;
        while(node!=null){
            stack.push(node);
            node=node.left;
        }
    }
    
    public int next() {
        TreeNode node=stack.pop();
        int val=node.val;
        node =node.right;
        while(node!=null){
            stack.push(node);
            node=node.left;
        }
        return val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
