package JAVA.SHASHCODE.LECTURE46;

// import java.util.ArrayList;
// import java.util.List;

public class Find_disappear_number {
    // public List<Integer> findDisappearedNumbers(int[] nums) {
    //     cyclicSort(nums);
    //     List<Integer> list=new ArrayList<Integer>();
    //     for(int i=0;i<nums.length;i++){
    //     if(nums[i]!=i+1){
    //         list.add(i+1);
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

    public int findDuplicate(int[] nums) {
        int arr[]=nums;
        for(int i=0;i<arr.length;i++){
            int element=Math.abs(arr[i]);
            int actualIndex=element-1;
            if(arr[actualIndex]<0){
                return element;
            }
            arr[actualIndex]=-1*arr[actualIndex];
        }
        return -1;
    }
}