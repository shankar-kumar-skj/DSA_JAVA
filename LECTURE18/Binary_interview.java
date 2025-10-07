package JAVA.SHASHCODE.LECTURE18;

public class Binary_interview {

    // leetcode => https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/1772598092/
    public static void main(String[] args) {
        // int arr[]={2,2,4,4,4,8,8,56,67,86,96};
        
        int arr2[]={4,4,8,8,8,15,16,23,23,42};
        // int[] res=new int[2];

        int first=binarySearch(arr2, 8,true);
        int last=binarySearch(arr2, 8,false);
        // res[0]=first;
        // res[1]=last;
        if(first==-1){
            System.out.println("Occurresnce of target is : "+0);
        }
        else{
            System.out.println("Occurresnce of target is : "+(last-first+1));
        }

        // FLOOR FINDING 
        int ans=binarySearchFloor(arr2, 5, true);
        System.out.println("Ans of floor is : "+ans);

        // FLOOR CEIL 
        int ans1=binarySearchCeil(arr2, 5, true);
        System.out.println("Ans of ceil is : "+ans1);

    }
    
    static int  binarySearch(int arr[],int target,boolean isFirst){
        int ans=-1;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                ans=mid;
                if(isFirst){
                    end =mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end = mid -1;
            }
        }
        return ans;
    }

    //find floor
    static int  binarySearchFloor(int arr[],int target,boolean isFirst){
        int ans=-1;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                ans=arr[mid];
                break;
            }
            else if(arr[mid]<target){
                start=mid+1;
                ans=arr[mid];
            }
            else{
                end = mid -1;
            }
        }
        return ans;
    }

    // find ceiling 
    static int  binarySearchCeil(int arr[],int target,boolean isFirst){
        int ans=-1;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                ans=arr[mid];
                break;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end = mid -1;
                ans=arr[mid];
            }
        }
        return ans;
    }
}
