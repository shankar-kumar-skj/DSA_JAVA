package JAVA.SHASHCODE.LECTURE42;

public class Radix_sort {
    public static void main(String args[]){
        System.out.println("COUNTING SORTING ALGO");
        int arr[]={2,65,33,55,76,54,3};
        printArray(arr, "original array");
        int res[]=radixSort(arr);
        printArray(res, "sorted array");

    }
    public static int radixSort(int arr[],int digit){
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
            int countVal=--countArr[val];
            res[countVal]=val;
        }
        return res;
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
}
