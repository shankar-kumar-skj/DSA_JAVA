package JAVA.SHASHCODE.LECTURE20;
import java.util.Scanner;


public class Binary_infinite {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(arr[i]);
        // }
        
        // Find Minimum Absolute Difference
        FindMinimumAbsoluteDifference(arr,target);

        // find range of infinite array
        int range[]=findRangeInfiniteArray(arr, target);
        System.out.println(range[0]+","+range[1]);

        // BINARY SEARCH IN RANGE
        int ans=binarySearchInRange(arr, target, range[0], range[1]);
        if(ans==-1){
            System.out.println("Elements does not exist");
        }
        else{
            System.out.println("Elements found at : "+ ans);
        }

        // find Element InInfinite Sorted Array
        findElementInInfiniteSortedArray(arr, target);

        // VARITATION
        // IN 0 AND 1 1ST "1" OCCURE CODE.
        int arr1[]={0,0,0,0,1,1,1,1,0,1};
        findFirstOneInBinaryInfiniteSortedArray(arr1);

        sc.close();
    }

    // Minimum absolute difference 
    static void FindMinimumAbsoluteDifference(int arr[],int target){

        if(arr.length==0){
            return ;
        }
        int ans=-1;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                ans=mid;
                break;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        // if element exist then ans = 0
        int res=0;

        // element does not exists
        if(ans==-1){
            if(end==-1){
                res=Math.abs(target-arr[start]);
            }
            else if(start==arr.length){
                res=Math.abs(target-arr[end]);
            }
            else{
                int ans1=Math.abs(target-arr[start]);
                int ans2=Math.abs(target-arr[end]);
                res=(ans1<ans2)?ans1:ans2;
            }
        }
        System.out.println("Minimum Absolute Difference is : "+ res);
    }

    // find Range Infinite Array
    static int[] findRangeInfiniteArray(int arr[],int target){
        int range[]=new int[2];

        int start=0;
        int end=1;

        while(arr[end]<target){
            start=end;
            end=2*end;
        }
        range[0]=start;
        range[1]=end;

        return range;
    }

    // binary Search In Range
    static int binarySearchInRange(int arr[],int target,int start,int end){
        int ans=-1;
        while(start<=end){
            int mid =start+(end-start)/2;
            if(arr[mid]==target){
                ans=mid;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }

    // find Element InInfinite Sorted Array
    static void findElementInInfiniteSortedArray(int arr[],int target){
        int range[]=findRangeInfiniteArray(arr, target);
        int ans=binarySearchInRange(arr, target, range[0], range[1]);
        if(ans==-1){
            System.out.println("Elements does not exist");
        }
        else{
            System.out.println("Elements found at : "+ ans);
        }
    }

    // find First One In Binary Infinite Sorted Array
    static void findFirstOneInBinaryInfiniteSortedArray(int arr[]){
        int range[]=findRangeInfiniteArray(arr, 1);
        int ans=binarySearchFirstOccurance(arr,1,range[0],range[1]);
        if(ans==-1){
            System.out.println("Elements does not exist");
        }
        else{
            System.out.println("Elements found at : "+ ans);
        }
    }

    // Binary FIRST OCCURENCE CODE
    static int binarySearchFirstOccurance(int arr[],int target,int start,int end){
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                ans=mid;
                end=mid-1;
            }else if( arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }


    
}
