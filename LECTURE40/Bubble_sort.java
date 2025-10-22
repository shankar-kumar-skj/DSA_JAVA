package JAVA.SHASHCODE.LECTURE40;

public class Bubble_sort {
    public static void main(String args[]){
        System.out.println("BUBBLE SORTING ALGO");
        int arr[]={2,65,33,55,76,54,3};
        printArray(arr, "original array");
        bubbleSort(arr);
        printArray(arr, "sorted array");
        System.out.println("BRICK SORTING ALGO");
        int arr1[]={2,65,33,55,76,54,3};
        printArray(arr1, "original array");
        brickSort(arr1);
        printArray(arr1, "sorted array");


    }
    public static void bubbleSort(int arr[]){
        int n=arr.length;
        int passes=n-2;
        for(int i=0;i<=passes;i++){
            boolean flag=false;
            for(int j=0;j<=passes-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flag=true;
                }
            }
            if(!flag){
                System.out.println("No swaps");
            }
            printArray(arr,"Array after pass"+i);
        }
    }
    public static void swap(int arr[],int index1,int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
    public static void printArray(int arr[],String message){
        System.out.println("Printing "+ message);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i!=arr.length-1){
                System.out.print(",");
            }
        }
    }

    // parity sort /  odd-even sort / brick sort
    public static void brickSort(int arr[]){
        int n=arr.length;
        boolean isSorted=false;
        while(!isSorted){ // isSorted == false
            boolean flag=false;
            // even index swapping
            for(int i=0;i<=n-2;i+=2){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                    flag=true;
                }
            }
            // odd index swapping
            for(int i=1;i<=n-2;i+=2){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                    flag=true;
                }
            }

            if(!flag){
                isSorted=true;
                break;
            }
        }
    }

}
