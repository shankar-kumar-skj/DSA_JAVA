package JAVA.SHASHCODE.LECTURE38;

// time compllexity = 0(n^2)
// space compllexity = 0(1) => implace used so!

public class Insertion_sort {
    public static void main(String[] args) {
        int arr[]={1,4,2,6,4,89,4,8};
        instertionSort(arr);
        printArray(arr, "sorted array");
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
    public static void instertionSort(int arr[]){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;
            // shifting logic
            while(j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            // place the key at j+1
            arr[j+1]=key;
        }
    }
}
