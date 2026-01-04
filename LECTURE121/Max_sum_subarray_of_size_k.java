package JAVA.SHASHCODE.LECTURE121;

import java.util.ArrayList;

public class Max_sum_subarray_of_size_k {
    static long maximumSumSubarray(int k,ArrayList<Integer> Arr, int N){
        long maxSum=0;
        long sum=0;
        // first find sum of K elemnents
        int index=0;
        while (index<N && index<k) {
            sum+=Arr.get(index);
            index++;
        }
        maxSum=sum;
        for(int i=1;i<N-k+1;i++){
            int prevElement=Arr.get(i-1);
            int nextElement=Arr.get(i+k-1);
            sum=sum-prevElement+nextElement; 
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }

    // same code not array list used

    public int maxSubarraySum(int[] Arr, int k) {
        int N=Arr.length;
        int maxSum=0;
        int sum=0;
        
        // first find sum of K elemnents
        int index=0;
        while (index<N && index<k) {
            sum+=Arr[index];
            index++;
        }
        maxSum=sum;
        for(int i=1;i<N-k+1;i++){
            int prevElement=Arr[i-1];
            int nextElement=Arr[i+k-1];
            sum=sum-prevElement+nextElement; 
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
