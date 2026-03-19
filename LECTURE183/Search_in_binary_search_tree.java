package JAVA.SHASHCODE.LECTURE183;

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

public class Search_in_binary_search_tree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null || root.val==val){
            return root;
        }
        TreeNode ans=null;
        if(val<root.val){
            ans=searchBST(root.left, val);
        }
        else{
            ans=searchBST(root.right, val);
        }
        return ans; // null Or Address of the node
    }
}
