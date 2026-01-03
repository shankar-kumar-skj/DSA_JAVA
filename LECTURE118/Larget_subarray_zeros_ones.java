package JAVA.SHASHCODE.LECTURE118;

import java.util.HashMap;

public class Larget_subarray_zeros_ones {
     public int maxLen(int[] arr) {
        // Your code here
        int N=arr.length;
        HashMap<Integer,Integer> sumMap=new HashMap<Integer,Integer>();
        sumMap.put(0,-1);
        int sum =0,maxLen=0;
        for(int i=0;i<N;i++){
            sum=(arr[i]==0)?(sum-1):(sum+1);
            if(sumMap.containsKey(sum)){
                int len=i-sumMap.get(sum);
                maxLen = Math.max(maxLen,len);
            }
            else{
                sumMap.put(sum,i);
            }
        }
        return maxLen;
    }
}
