package JAVA.SHASHCODE.LECTURE22;
import java.util.*;

public class Rotated_array {
    public static void main(String[] args) {

    }

    // find in sorted rotated array
    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }

            // left side is sorted
            if (arr[start] <= arr[mid]) {
                // can ans be found in left side?
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            // right side is sorted
            else {
                // can be found in right side?
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return ans;
    }

    // SEARCHING IN ROTATED SORTED ARRAY (DUPLICATES)

    // T.C. => logN + O(N/2);
    // if start,mid and end all are same then we can't guarentee which part is
    // sorted so we will trim down the space.
    public boolean searchII(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        Boolean ans = false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            // left side is sorted
            else if (nums[start] <= nums[mid]) {
                // can ans be found in left side?
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            // right side is sorted
            else {
                // can be found in right side?
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return ans;
    }

    // FIND THE MIN ELEMENT IN ROTATED SORTED ARRAY
    public int findMin(int[] nums){
        int n=nums.length;
        int start=0;
        int end=n-1;
        int minElement=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+ (end-start)/2;
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            else if(nums[start]<=nums[mid]){
                minElement=Math.min(minElement,nums[start]);
                start=mid+1;
            }
            else{
                minElement=Math.min(minElement,nums[mid]);
                end=mid-1;
            }
        }
        return minElement;
    }
    
    // FIND THE MIN ELEMENT IN ROTATED SORTED ARRAY DUPLICATE
    public int findMinDuplicate(int[] nums){
        int n=nums.length;
        int start=0;
        int end=n-1;
        int minElement=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+ (end-start)/2;
            if(nums[start]<=nums[mid]){
                minElement=Math.min(minElement,nums[start]);
                start=mid+1;
            }
            else{
                minElement=Math.min(minElement,nums[mid]);
                end=mid-1;
            }
        }
        return minElement;
    }

    // FIND THE NUMBER OF ROTATION
    public int HowManyRotation(int[] nums){
        int n=nums.length;
        int start=0;
        int end=n-1;
        int minElement=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+ (end-start)/2;
            if(nums[start]<=nums[mid]){
                minElement=Math.min(minElement,nums[start]);
                start=mid+1;
            }
            else{
                minElement=Math.min(minElement,nums[mid]);
                end=mid-1;
            }
        }
        return minElement;
    }

    // 
    public int findKRotation(List<Integer> arr){
        int n=arr.size();
        int start=0;
        int end=n-1;
        int minElement =Integer.MAX_VALUE;
        int minIndex=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr.get(start)<=arr.get(mid)){
                if(arr.get(start)<minElement){
                    minElement=arr.get(start);
                    minIndex=start;
                }
                start=mid+1;
            }
            else{
                // minElement=Math.min(minElement,arr[mid]);
                if(arr.get(mid)<minElement){
                    minElement=arr.get(start);
                    minIndex=mid;
                }
                end=mid-1;
            }
            return minIndex;
        }
    }
}
