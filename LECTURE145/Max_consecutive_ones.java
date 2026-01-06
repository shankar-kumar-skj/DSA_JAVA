package JAVA.SHASHCODE.LECTURE145;

public class Max_consecutive_ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                count++;
            }

            // reset
            if(nums[i]==0 || i==n-1){
                max=Math.max(max,count);
                count=0;
            }
        }
        return max;
    }
}
