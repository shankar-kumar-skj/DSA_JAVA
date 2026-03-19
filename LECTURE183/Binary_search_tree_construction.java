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

public class Binary_search_tree_construction {
    public static void main(String[] args) {
        int arr[]={};
        Binary_search_tree_construction obj =new Binary_search_tree_construction();
        TreeNode root =obj.constructBST(arr);
        obj.inorderTraversal(root);
    }
    public void inorderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        // left
        inorderTraversal(root.left);
        // root
        System.out.print(root.val +" ");
        // right
        inorderTraversal(root.right);
    }
    public TreeNode constructBST(int arr[]){
        TreeNode root=null;
        for(int i=0;i<arr.length;i++){
            root=insertIntoBST(root, arr[i]);
        }
        return root;
    }
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
