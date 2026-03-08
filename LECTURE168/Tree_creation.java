package JAVA.SHASHCODE.LECTURE168;

import java.util.*;

// PreOrder => Root is fixed, but there is no
//             guarantee for left and right subtree.
// PostOrder => Root is fixed, but there is no
//             guarantee for left and right subtree.
// InOrder => Root is  not fixed, but if we know the 
//            root, we can easily find out left and 
//            right subtree.


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

public class Tree_creation {
    // // Inorder + PreOrder combine to form tree

    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     HashMap<Integer,Integer> indexMap=new HashMap<>();
    //     // hash the value with index
    //     for (int i=0;i<inorder.length;i++){
    //         indexMap.put(inorder[i],i);
    //     }
    //     int n=preorder.length-1;
    //     int m=inorder.length-1;
    //     TreeNode root =constructTree(preorder,inorder,indexMap,0,n,0,m);
    //     return root;
    // }
    // public TreeNode constructTree(int[] preorder,int[] inorder,HashMap<Integer,Integer> indexMap,int preIndStart, int preIndEnd, int inIndStart, int inIndEnd){
    //     // handle the bass case
    //     if(preIndStart>preIndEnd || inIndStart>inIndEnd){
    //         return null;
    //     }
    //     int rootData=preorder[preIndStart];
    //     int rootIndex=indexMap.get(rootData);
    //     TreeNode root=new TreeNode(rootData);
    //     int leftTreeSize = rootIndex-inIndStart;
    //     int rightTreeSize=inIndEnd-rootIndex;
    //     root.left= constructTree(preorder, inorder, indexMap, preIndStart+1, preIndStart+leftTreeSize, inIndStart, rootIndex-1);
    //     root.right= constructTree(preorder, inorder, indexMap, preIndStart+leftTreeSize+1, preIndStart+leftTreeSize+1+rightTreeSize, rootIndex+1, inIndEnd);
    //     return root;
    // }

    // Inorder + Post order Traversal to form tree
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> indexMap=new HashMap<>();
        // hash the value with index
        for (int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        int n=postorder.length-1;
        int m=inorder.length-1;
        TreeNode root =constructTree(postorder,inorder,indexMap,0,n,0,m);
        return root;
    }
    public TreeNode constructTree(int[] postorder,int[] inorder,HashMap<Integer,Integer> indexMap,int postIndStart, int postIndEnd, int inIndStart, int inIndEnd){
        // handle the bass case
        if(postIndStart>postIndEnd || inIndStart>inIndEnd){
            return null;
        }
        int rootData=postorder[postIndEnd];
        int rootIndex=indexMap.get(rootData);
        TreeNode root=new TreeNode(rootData);
        int leftTreeSize = rootIndex-inIndStart;
        int rightTreeSize=inIndEnd-rootIndex;
        root.left= constructTree(postorder, inorder, indexMap, postIndStart, postIndStart+leftTreeSize-1, inIndStart, rootIndex-1);
        root.right= constructTree(postorder, inorder, indexMap, postIndStart+leftTreeSize, postIndStart+leftTreeSize+rightTreeSize-1, rootIndex+1, inIndEnd);
        return root;
    }
}
