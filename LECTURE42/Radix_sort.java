package JAVA.SHASHCODE.LECTURE42;

public class Radix_sort {
    public static void main(String args[]){
        System.out.println("COUNTING SORTING ALGO");
        int arr[]={2,65,33,55,76,54,3};
        printArray(arr, "original array");
        radixSort(arr);
        printArray(arr, "sorted array");

    }
    public static void countingSortWithDigit(int arr[],int digit){
        // find k
        int n=arr.length;
        int k=9;
        int res[]=new int[n];

        int countArr[]=new int[k+1];
        // find the frequency
        for(int i=0;i<n;i++){
            int index=(arr[i]/digit)%10;
            countArr[index]+=1;
        }

        // /find cumulative frequency
        for(int i=1;i<=k;i++){
            countArr[i]+=countArr[i-1];
        }

        // /find the sorted array
        for(int i=n-1;i>=0;i--){
            int val=arr[i];
            // /a-- & --a
            int countIndex=(arr[i]/digit)%10;
            int countVal=--countArr[countIndex];
            res[countVal]=val;
        }
        // copy back to the original array
        for(int i=0;i<n;i++){
            arr[i]=res[i];
        }
    }

    // PRINT ARRAY
    public static void printArray(int arr[],String message){
        System.out.println("Printing "+ message);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i!=arr.length-1){
                System.out.print(",");
            }
        }
    }

    public static void radixSort(int arr[]){
        int n=arr.length;
        int maxEl=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>maxEl){
                maxEl=arr[i];
            }
        }
        if(maxEl == Integer.MIN_VALUE){
            System.out.println("Empty array");
            return;
        }
        for(int digit=1;maxEl/digit>0;digit*=10){
            countingSortWithDigit(arr, digit);
        }
    }
}
