package JAVA.SHASHCODE.LECTURE123;

import java.util.ArrayList;
import java.util.Collections;

public class Chocolate_Distribution_problem {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here

        int n=arr.size();
        if(n==0){
            return 0;
        }
        int res=Integer.MAX_VALUE;
        Collections.sort(arr);

        for(int i=0;i<n-m+1;i++){
           int minElement=arr.get(i);
           int maxElement=arr.get(i+m-1);
           res=Math.min(res,maxElement-minElement);
        }
        return res;
    }
}
