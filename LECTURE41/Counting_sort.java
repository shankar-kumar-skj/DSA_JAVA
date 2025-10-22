package JAVA.SHASHCODE.LECTURE41;

// frequency comparing algo and not compare the number this algorithm basically sort using their frequency (no. of number available)
// not handle negative number 
// takes large amount of space
// inplace algorithm not possible because if you do that then comparision not possible
public class Counting_sort {
    public static void main(String args[]){
        System.out.println("COUNTING SORTING ALGO");
        int arr[]={2,65,33,55,76,54,3};
        printArray(arr, "original array");
        int res[]=countingSort(arr);
        printArray(res, "sorted array");

    }
    public static int[] countingSort(int arr[]){
        // find k
        int n=arr.length;
        int k=Integer.MIN_VALUE;
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            if(arr[i]>k){
                k=arr[i];
            }
        }
        if(k==Integer.MIN_VALUE){
            System.out.println("Empty value");
            return res;
        }

        int countArr[]=new int[k+1];
        // find the frequency
        for(int i=0;i<n;i++){
            int index=arr[i];
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
