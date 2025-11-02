package JAVA.SHASHCODE.LECTURE65;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Next_greater_element {
    // public stack long[] nextLargerElement(int[] arr) {
    //     // code here
    //     Stack<Long> stack=new Stack<>();
    //     int n=arr.length;
    //     long res[]=new long[n];
    //     for(int i=n-1;i>=0;i--){
    //         while(!stack.isEmpty() && stack.peek()<=arr[i]){
    //             stack.pop();
    //         }
    //         if(stack.isEmpty()){
    //             res[i]=-1;
    //         }
    //         else{
    //             res[i]=stack.peek();
    //         }
    //         stack.push(arr[i]);
    //     }
    //     return res;
    // }

    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res.set(i, stack.peek());
            }
            stack.push(arr[i]);
        }
        
        return res;
    }
}
