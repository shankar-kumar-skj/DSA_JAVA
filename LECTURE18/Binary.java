package JAVA.SHASHCODE.LECTURE18;

public class Binary {
    public static void main(String[] args){
        int arr1[]={2,5,7,11,45,87,90};
        int arr2[]={90,45,32,22,21,6,3};
        
        binarySearch(arr1, 87);

        binarySearchResverse(arr2, 32);

        // Search Order Agnostic
        binarySearchOrderAgnostic(arr2, 32);
        binarySearchOrderAgnostic(arr1, 87);

    }

    static void binarySearch(int arr[],int target){
        int ans=-1;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
          int mid =start+(end-start)/2;
          if(arr[mid]== target){
            ans=mid;
            break;
          }
          else if(arr[mid]>target){
            end=mid-1;
          }
          else{
            start=mid +1;
          }

        }
        if (ans==-1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found : "+ans);
        }
    }

    static void binarySearchResverse(int arr[],int target){
        int ans=-1;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
          int mid =start+(end-start)/2;
          if(arr[mid]== target){
            ans=mid;
            break;
          }
          else if(arr[mid]>target){
            end=mid-1;
          }
          else{
            start=mid+1;
          }

        }
        if (ans==-1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found : "+ans);
        }
    }

    // order agnostic binary search
    static void binarySearchOrderAgnostic(int arr[],int target){
      int start=0;
      int end=arr.length-1;
      if(arr[start]<=arr[end]){
        binarySearch(arr, target);
      }
      else{
        binarySearchResverse(arr, target);
      }
    }

}
