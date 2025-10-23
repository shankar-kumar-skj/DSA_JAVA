package JAVA.SHASHCODE.LECTURE43;

// time complexity => O(N+K) => O(N)
// SPACE COMPEXITY => O(N)

public class Pigeon_hole_sort {
    public static void main(String args[]){
        System.out.println("PIGEON HOLE SORTING ALGO");
        int arr[]={2,65,33,55,76,54,3};
        printArray(arr, "original array");
        pigeonHoleSort(arr);
        printArray(arr, "sorted array");
    }
    public static void pigeonHoleSort(int arr[]){
        int n=arr.length;
        int minEl=Integer.MAX_VALUE;

        // max elemnt find
        int maxEl=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>maxEl){
                maxEl=arr[i];
            }
            if(arr[i]<minEl){
                minEl=arr[i];
            }
        }
        if(maxEl == Integer.MIN_VALUE || minEl==Integer.MAX_VALUE){
            System.out.println("Empty array");
            return;
        }

        int size=maxEl-minEl+1;
        int pigeonHole[]=new int[size];

        // find the count
        for(int i=0;i<n;i++){
            int index=arr[i]-minEl;
            pigeonHole[index]++;
        }

        int insertionIndex=0;
        // fill the original array
        for(int j=0;j<size;j++){
            while(pigeonHole[j]>0){
                arr[insertionIndex]=j+minEl;
                pigeonHole[j]--;
            }
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
}
