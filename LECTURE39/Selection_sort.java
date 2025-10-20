package JAVA.SHASHCODE.LECTURE39;

public class Selection_sort {
    public static void main(String args[]){
        int arr[]={3,5,2,6,6,87,99,23,44,12,7};
        selectionSort(arr);
        printArray(arr, "sorted array");
    }
    public static void selectionSort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int minEl=arr[i];
            int minIndex=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<minEl){
                    minEl=arr[j];
                    minIndex=j;
                }
            }
            swap(arr,i,minIndex);
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
}
