package JAVA.SHASHCODE.LECTURE47;

import java.util.ArrayList;
import java.util.List;

public class Find_duplicate_number {
    // public int findDuplicate(int[] nums) {
    //     cyclicSort(nums);
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]!=i+1){
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }
    // public void cyclicSort(int nums[]){
    //     int n=nums.length;
    //     int index=0;
    //     while(index<n){
    //         int element = nums[index];
    //         int correctPos=element-1;
    //         if(nums[index]!=nums[correctPos]){
    //             swap(nums,index,correctPos);
    //         }
    //         else{
    //             index++;
    //         }
    //     }
    // }
    // public void swap(int arr[],int index1,int index2){
    //     int temp=arr[index1];
    //     arr[index1]=arr[index2];
    //     arr[index2]=temp;
    // }


    // leetcode => 442

    // method 1 :-

    // public List<Integer> findDuplicates(int[] nums) {
    //     cyclicSort(nums);
        
    //     List<Integer> list=new ArrayList<Integer>();
    //     for(int i=0;i<nums.length;i++){
    //     if(nums[i]!=i+1){
    //         list.add(nums[i]);
    //     }
    // }
    // return list;
    // } 
    

    // public void cyclicSort(int nums[]){
    //     int n=nums.length;
    //     int index=0;
    //     while(index<n){
    //         int element = nums[index];
    //         int correctPos=element-1;
    //         if(nums[index]!=nums[correctPos]){
    //             swap(nums,index,correctPos);
    //         }
    //         else{
    //             index++;
    //         }
    //     }
    // }
    // public void swap(int arr[],int index1,int index2){
    //     int temp=arr[index1];
    //     arr[index1]=arr[index2];
    //     arr[index2]=temp;
    // }

    // method 2:-

    public List<Integer> findDuplicates(int[] nums) {
        int arr[]=nums;
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            int element=Math.abs(arr[i]);
            int actualIndex=element-1;
            if(arr[actualIndex]<0){
                list.add(element);
            }
            arr[actualIndex]=-1*arr[actualIndex];
        }
        return list;
    } 

    public int findDuplicatesCount(int[] nums) {
        int arr[]=nums;
        int count=0;
        // List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            int element=Math.abs(arr[i]);
            int actualIndex=element-1;
            if(arr[actualIndex]<0){
                count++;
                // list.add(element);
            }
            else{
                arr[actualIndex]=-1*arr[actualIndex];
            }
        }
        return count;
    } 
    
    
}
