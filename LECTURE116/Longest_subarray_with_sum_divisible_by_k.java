package JAVA.SHASHCODE.LECTURE116;

import java.util.HashMap;

public class Longest_subarray_with_sum_divisible_by_k {
    

    int longestSubarrayDivK(int[] arr, int k) {
        // Complete the function
        int n=arr.length;
        HashMap<Integer,Integer> reMap=new HashMap<>();
        reMap.put(0,-1); //to handle subarray starting from index 0
        long sum=0;
        int maxLen=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int rem = (int) (sum%k);
            
            // convert negative remainder to positive 
            if(rem<0){
                rem+=k;
            }
            if(reMap.containsKey(rem)){
                int len =i-reMap.get(rem); // UL - LL
                maxLen=Math.max(maxLen,len);
            }
            else{
               reMap.put(rem,i);
            }
        }
        return maxLen;
    }
}

