package JAVA.SHASHCODE.LECTURE174;

// import java.util.*;
class Node{
    int data;
    Node left,right;
    Node (int d){
        data=d;
        left=right=null;
    }
}

public class Sum_of_binary_tree {
    static int sumBT(Node head){
        if(head==null){
            return 0;
        }
        int leftSum=sumBT(head.left);
        int rightSum=sumBT(head.right);
        return (leftSum+rightSum+head.data);

    }
}
