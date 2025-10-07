package JAVA.SHASHCODE.LECTURE25;

public class Smallest_divisor_threshold {
    public static void main(String [] args){

    }
    public int smallestDivisor(int[] nums, int threshold) {
        int start=1;
        int end=Integer.MIN_VALUE;
        // FIND THE MAXOIMUM POSSIBLE DIVISOR
        for(int i=0;i<nums.length;i++){
            if(nums[i]>end){
                end=nums[i];
            }
        }
        int res=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isDivisionPossible(nums,mid,threshold)){
                res=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return res;
    }
    static boolean isDivisionPossible(int nums[],int divisor,int threshold){
        int sumOfDivision=0;
        for(int i=0;i<nums.length;i++){
            sumOfDivision+=nums[i]/divisor;
            if(nums[i]%divisor!=0){
                sumOfDivision+=1;
            }
            if(sumOfDivision>threshold){
                return false;
            }
        }
        return true;
    }
}
