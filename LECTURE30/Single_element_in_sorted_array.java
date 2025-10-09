package JAVA.SHASHCODE.LECTURE30;

public class Single_element_in_sorted_array {
    public int singleNonDuplicate(int[] nums) {
        int start=0;
        int end=nums.length-2;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==nums[mid^1]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return nums[start];
    }
}
