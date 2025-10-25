package JAVA.SHASHCODE.LECTURE45;

public class Missing_Number {
    public static void main(String[] args) {
        
    }
    public int missingNumber(int[] nums) {
        // sum total of n - sum of numbers given
        int n=nums.length;
        int expectedSum=n*(n+1)/2;
        int actualSum=0;
        for(int i=0;i<n;i++){
            actualSum+=nums[i];
        }
        return expectedSum-actualSum;
    } 
}
