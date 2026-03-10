package JAVA.SHASHCODE.LECTURE173;

// Node = (2^h - 1)
// TC => (log2 (N))^2

class Node{
    int val;
    Node right;
    Node left;
    Node(){

    }
    Node (int val,Node right,Node left){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}

public class Count_number_of_nodes_in_a_binary_tree {

    public static int findLeftHeight(Node root){
        int count=1;
        while(root.left!=null){
            count++;
            root = root.left;
        }
        return count;
    }

    public static int findRightHeight(Node root){
        int count=1;
        while(root.right!=null){
            count++;
            root = root.right;
        }
        return count;
    }

    public static void main(String args[]){

    }

    public static int countNodes(Node root){
        // base caser
        if(root==null){
            return 0;
        }

        // check if all levels are completely filled
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        if(leftHeight == rightHeight){
            return ((int)Math.pow(2,leftHeight)-1);
        }

        return 1 + countNodes(root.left)+ countNodes(root.right);
    }
}