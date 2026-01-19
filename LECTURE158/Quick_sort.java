package JAVA.SHASHCODE.LECTURE158;

public class Quick_sort {

    // QUICK SORT PIVOT ELEMENT AT MIDDLE

    // public void quickSort(int[] arr, int low, int high) {
    //     // code here
    //     if(low>=high){
    //         return;
    //     }
    //     int pi = partition(arr,low,high);
    //     quickSort(arr,low,pi-1);
    //     quickSort(arr,pi+1,high);
        
    // }

    // private int partition(int[] arr, int low, int high) {
        
    //     // code here
    //     int pivot = arr[low];
    //     int i=low;
    //     int j=high;
        
    //     while(i<j){
    //         while(i<high && arr[i]<=pivot){
    //             i++;
    //         }
    //         while(j>low && arr[j]>pivot){
    //             j--;
    //         }
            
    //         if(i<j){
    //             swap(arr,i,j);
    //         }
    //     }
    //     swap(arr,low,j);
    //     return j;
    // }
    
    // static void swap(int arr[],int i, int j){
    //     int temp=arr[i];
    //     arr[i]=arr[j];
    //     arr[j]=temp;
    // }

    // QUICK SORT PIVOT ELEMENT AT END
    public void quickSort(int[] arr, int low, int high) {
        // code here
        if(low>=high){
            return;
        }
        int pi = partition(arr,low,high);
        quickSort(arr,low,pi-1);
        quickSort(arr,pi+1,high);
        
    }

    private int partition(int[] arr, int low, int high) {
        
        // code here
        int pivot = arr[high];
        int i=low-1;
        
        for(int j=low;j<high;j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }
    
    static void swap(int arr[],int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
