package JAVA.SHASHCODE.LECTURE44;

// time complexity => O(N-2)+O(N-1) => O(N)
// SPACE COMPEXITY => O(1)

public class Cycle_sort {
    public static void main(String[] args) {
        System.out.println("CYCLIC SORTING ALGO 1 to n");
        int arr1[] = { 2, 3, 1, 5, 4 };
        printArray(arr1, "original array");
        cycleSort_1_to_n(arr1);
        System.out.println();
        printArray(arr1, "sorted array");
        System.out.println();
        System.out.println();
        System.out.println("CYCLIC SORTING ALGO 0 to n");
        int arr[] = { 2, 3, 1, 5, 4, 0 };
        printArray(arr, "original array");
        cycleSort_0_to_n(arr);
        System.out.println();
        printArray(arr, "sorted array");
        System.out.println();
        System.out.println();
        System.out.println("CYCLIC SORTING");
        int arr3[] = { 2, 23, 18, 5, 24, 10 };
        printArray(arr3, "original array");
        cycleSort(arr3);
        System.out.println();
        printArray(arr3, "sorted array");
    }

    // CYCLIC SORT VARIANTS
    // range => 1 to N
    public static void cycleSort_1_to_n(int arr[]) {
        int n = arr.length;
        int index = 0;
        while (index < n) {
            int element = arr[index];
            int actualPos = element - 1;

            // if element is not at the correct pos,then perform swapping
            if (arr[index] < n && arr[index] != arr[actualPos]) {
                swap(arr, index, actualPos);
            } else {
                index++;
            }
        }
    }

    // range => 1 to N
    public static void cycleSort_0_to_n(int arr[]) {
        int n = arr.length;
        int index = 0;
        while (index < n) {
            int element = arr[index];
            int actualPos = element;

            // if element is not at the correct pos,then perform swapping
            if (arr[index] < n && arr[index] != arr[actualPos]) {
                swap(arr, index, actualPos);
            } else {
                index++;
            }
        }
    }

    // swap
    public static void swap(int arr[], int index1, int index2) {
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }

    // PRINT ARRAY
    public static void printArray(int arr[], String message) {
        System.out.println("Printing " + message);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(",");
            }
        }
    }

    // CYCLIC ALGORITHM

    // CYCLIC DECOMPOSITION
    // => ARR[]={1,8,3,9,10,10,2,4};
    // (8,10,2)
    // 8 -> 10 -> 2 & 2-> 8 MEANS 8 SWAP TO 10 POSITION ,10 SWAP TO 2 POSITION AND 2
    // SWAP TO 8 POSITION.
    // => ARR[]={1,2,3,9,8,10,10,4}

    // CYCLES moves => 0 to (n-1)

    // time complexity => O(N-2)*O(N-1) => O(N^2)
    // SPACE COMPEXITY => O(1)
    public static void cycleSort(int arr[]) {
        int n = arr.length;
        for (int cycles = 0; cycles < n - 1; cycles++) {
            int pos = cycles;
            int item = arr[cycles];

            // find number of smaller element
            for (int i = cycles+1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }

            // element is at correct position
            if (pos == cycles) {
                continue;
            }

            // ignore the duplicates
            while (arr[pos] == item) {
                pos++;
            }

            // if smaller elements are found then perform swaping
            if (pos != cycles) {
                int temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }
            // check more swaps are required
            while (pos != cycles) {
                pos = cycles;
                // find number of smaller element
                for (int i = cycles+1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }

                // ignore duplicates
                while(arr[pos]==item){
                    pos++;
                }

                if(item!=arr[pos]){
                int temp = arr[pos];
                arr[pos] = item;
                item = temp; 
                }
            }
        }
    }
}
