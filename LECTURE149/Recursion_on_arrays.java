package JAVA.SHASHCODE.LECTURE149;

import java.util.ArrayList;

public class Recursion_on_arrays {
    private void printArray(int index,int arr[]){
        // base case
        if (index == arr.length) return;
        System.out.println(arr[index]+" "); 
        printArray(index+1, arr);
    }

    private void printReverseArray(int index,int arr[]){
        // base case
        if (index == arr.length) return;
        printReverseArray(index+1, arr);
        System.out.println(arr[index]+" ");
    }

    public static void main(String[] args) {
        int arr[]={7,6,1,4,5,8,0,2};
        Recursion_on_arrays pd=new Recursion_on_arrays();
        pd.printArray(0, arr);
        System.out.println("\n Reverse array is : ");
        pd.printReverseArray(0, arr);

    }
}

class SearchElementInArray{
    private boolean checkElement(int arr[],int index,int target){
        // base case
        if(index==arr.length) return false;
        if(arr[index]==target) return true;
        return checkElement(arr, index+1, target);
    }

    public static void main(String[] args) {
        int arr[]={7,6,1,4,5,8,0,2};
        int target=11;
        SearchElementInArray pd=new SearchElementInArray();
        boolean res= pd.checkElement(arr, 0, target);
        System.out.println("Is "+ target + " present in array : "+res);
    }
}

// find first occurance of element in array otherwise return -1.

class FirstOccurance{
    private int firstOccuranceFunction(int arr[],int index,int target){
        // base case
        if(index==arr.length) return -1;
        if(arr[index]==target) return index+1;
        return firstOccuranceFunction(arr, index+1, target);
    }

    public static void main(String[] args) {
        int arr[]={7,6,1,4,5,8,0,2};
        int target=11;
        FirstOccurance fo=new FirstOccurance();
        int res= fo.firstOccuranceFunction(arr, 0, target);
        if(res==-1){
            System.out.println(target + " is not present in array : ");
        }
        else{
            System.out.println("First occurance of "+ target + " in array is : "+res);
        }
    }
}

// find Last occurance of element in array otherwise return -1.

class LastOccurance{
    private int lastOccuranceFunction(int arr[],int index,int target){
        // base case
        if(index==arr.length) return -1;
        int res=lastOccuranceFunction(arr, index+1, target);
        if(res==-1){
            if(arr[index]==target) return index;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[]={7,6,1,4,5,8,0,2};
        int target=11;
        LastOccurance fo=new LastOccurance();
        int res= fo.lastOccuranceFunction(arr, 0, target);
        if(res==-1){ 
            System.out.println(target + " is not present in array : ");
        }
        else{
            System.out.println("Last occurance of "+ target + " in array is : "+res);
        }
    }
}

// https://www.geeksforgeeks.org/problems/find-index4752/1

class Solution {
    // Function to find starting and end index
    static int[] findIndex(int arr[], int key) {
        // code here.
        int res[]={-1,-1};
        findOccurrence(0,arr,key,res);
        return res;
        
    }
    static void findOccurrence(int index,int arr[],int key,int res[]){
        // base case 
        if(index==arr.length) return ;
        
        if(arr[index] ==key){
            res[1]=index;
        }
        
        findOccurrence(index+1,arr,key,res);
        if(arr[index] ==key){
            res[0]=index;
        }
    }
}

// find all occurance in the array

class Solution4 {

    static ArrayList<Integer> findIndex(int arr[], int key) {
        ArrayList<Integer> res = new ArrayList<>();
        findOccurrence(0, arr, key, res);
        return res;
    }

    static void findOccurrence(int index, int arr[], int key, ArrayList<Integer> res) {
        // Base case
        if (index == arr.length) {
            return;
        }

        // If key found, store index
        if (arr[index] == key) {
            res.add(index);
        }

        // Recursive call
        findOccurrence(index + 1, arr, key, res);
    }

    // Driver code for testing
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 5};
        int key = 2;

        ArrayList<Integer> result = findIndex(arr, key);
        System.out.println(result); // Output: [1, 3, 4]
    }
}

// Binary Search using recursion
class BinarySearch {

    // Function for binary search
    private boolean binarySearchfunction(int start,int end,int target,int arr[] ) {
        // base case
        if(start>end) return false;
        int mid=start + (end-start)/2;
        if(arr[mid]==target) return true;
        if(target<arr[mid]){
            return binarySearchfunction(start, mid-1, target, arr);
        }
        else{
            return binarySearchfunction(mid-1,end, target, arr);
        }
        
    }

    public static void main(String[] args) {
        int arr[]={2,2,3,4,5,8,10,10};
        int target=4;
        BinarySearch fo=new BinarySearch();
        boolean res=fo.binarySearchfunction(0, arr.length-1, target, arr);
        System.out.println("Is "+target+" present in Array : "+res);
    }
}