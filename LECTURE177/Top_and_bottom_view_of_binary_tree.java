package JAVA.SHASHCODE.LECTURE177;

import java.util.*;

// TC => O(N)* Log(N)
// SC => Queue + Map => O(N + N) == O(N)
// NO USING DFS

class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}


public class Top_and_bottom_view_of_binary_tree {

    // // TOP VIEW 
//     static class CustomNode{
//         Node node;
//         int col;
//         CustomNode(Node node, int col){
//             this.node=node;
//             this.col=col;
//         }
//     }
//     static ArrayList<Integer> topView(Node root){
//         ArrayList<Integer> res=new ArrayList<>();
//         if(root==null) {
//             return res;
//         }

//         Queue<CustomNode> queue=new LinkedList<>();
//         queue.offer(new CustomNode(root, 0));
//         TreeMap <Integer,Integer> map=new TreeMap<>();

//         while(!queue.isEmpty()){
//             CustomNode customNode=queue.poll();
//             Node node= customNode.node;
//             int col = customNode.col;
//             if(!map.containsKey(col)){
//                 map.put(col,node.data);
//             }
//             if(node.left!=null){
//                 queue.offer(new CustomNode(node.left, col-1));
//             }
//             if(node.right!=null){
//                 queue.offer(new CustomNode(node.right, col+1));
//             }
//         }

//         for(Map.Entry<Integer,Integer> entry: map.entrySet()){
//             res.add(entry.getValue());
//         }
//         return res;
// }



    // Bootom View
    // class CustomNode{
    //     Node node;
    //     int col;
    //     CustomNode(Node node, int col){
    //         this.node=node;
    //         this.col=col;
    //     }
    // }
    // public ArrayList<Integer> bottomView(Node root){
    //     ArrayList<Integer> res=new ArrayList<>();
    //     if(root==null) {
    //         return res;
    //     }

    //     Queue<CustomNode> queue=new LinkedList<>();
    //     queue.offer(new CustomNode(root, 0));
    //     TreeMap <Integer,Integer> map=new TreeMap<>();

    //     while(!queue.isEmpty()){
    //         CustomNode customNode=queue.poll();
    //         Node node= customNode.node;
    //         int col = customNode.col;
    //         map.put(col,node.data);
    //         if(node.left!=null){
    //             queue.offer(new CustomNode(node.left, col-1));
    //         }
    //         if(node.right!=null){
    //             queue.offer(new CustomNode(node.right, col+1));
    //         }
    //     }

    //     for(Map.Entry<Integer,Integer> entry: map.entrySet()){
    //         res.add(entry.getValue());
    //     }
    //     return res;
    // }


    // if case of right to left bottom view
    class CustomNode{
        Node node;
        int col;
        CustomNode(Node node, int col){
            this.node=node;
            this.col=col;
        }
    }
    public ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) {
            return res;
        }

        Queue<CustomNode> queue=new LinkedList<>();
        queue.offer(new CustomNode(root, 0));
        TreeMap <Integer,Integer> map=new TreeMap<>();

        while(!queue.isEmpty()){
            CustomNode customNode=queue.poll();
            Node node= customNode.node;
            int col = customNode.col;
            map.put(col,node.data);
            
            if(node.right!=null){
                queue.offer(new CustomNode(node.right, col+1));
            }
            if(node.left!=null){
                queue.offer(new CustomNode(node.left, col-1));
            }
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
