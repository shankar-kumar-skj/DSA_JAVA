package JAVA.SHASHCODE.LECTURE170;

import java.util.*;

// TC => O(n)
// Sc => O(Levels or Height of the tree) 

// LEVEL OF TREE = HEIGHT OF TREE

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Max_depth_of_a_binary_tree_of_n_array {
    public int maxDepth(Node root) {
        if(root ==null) return 0;
        int maxDepth=0;
        for(Node node: root.children){
            if(null!=null){
                maxDepth=Math.max(maxDepth,maxDepth(node));
            }
        }
        return (1+maxDepth);
    }
}
