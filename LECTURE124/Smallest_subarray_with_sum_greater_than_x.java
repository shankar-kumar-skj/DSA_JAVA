package JAVA.SHASHCODE.LECTURE124;

// variable length sliding window
// TC => expansion + srink => O(N) + O(N) => O(2N) ~= O(N)
// SC => O(1)

public class Smallest_subarray_with_sum_greater_than_x {
    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int n=arr.length;
        int windowStart=0;
        int windowEnd=0; //i
        int sum=0;
        int minLen=Integer.MAX_VALUE;
        int len=0;
        while (windowEnd<n) {
            // expansion
            sum+=arr[windowEnd];
            if(sum>x){

                len=windowEnd-windowStart+1;
                minLen=Math.min(minLen,len);
                while(windowStart<windowEnd && sum>x){
                    sum-=arr[windowStart];
                    windowStart++;
                    if(sum>x){
                        len=windowEnd-windowStart+1;
                        minLen=Math.min(minLen,len);
                    }
                }
            }
            windowEnd++;
        }
        return (minLen==Integer.MAX_VALUE)?0:minLen;
    }
}
