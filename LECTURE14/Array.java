
// package JAVA.SHASHCODE.LECTURE14;
// import java.util.ArrayList; 
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        // DYNAMIC ARRAY
        // ArrayList<Integer> dynamic=new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int rollNo[] = new int[5];
        // int age[];
        // age =new int[7];
        // int dummy[]={2,6,7,9,2,13,2};
        // rollNo[0]=54;

        System.out.println("ADDRESS :" + rollNo);

        for (int i = 0; i < rollNo.length; i++) {
            System.out.print("ENTER THE ELEMNT " + (i + 1) + ": ");
            rollNo[i] = sc.nextInt();
        }

        printArray(rollNo);
        int position = sc.nextInt();
        int element = sc.nextInt();

        update(rollNo, position, element);

        insert(rollNo, position, element);
        printArray(rollNo);

        delete(rollNo, position);
        printArray(rollNo);

        // insertion in 2D ARRAY
        int my2dArray[][] = new int[3][2];
        for (int i = 0; i < my2dArray.length; i++) {
            for (int j = 0; j < my2dArray[i].length; j++) {
                System.out.print("ENTER THE ELEMNT " + j + ": ");
                my2dArray[i][j] = sc.nextInt();
            }
        }

        // PRINT 2D ARRAY
        print2dArray(my2dArray);

        // insert in 2D ARRAY in any position
        System.out.println("POSITION 1 ON 2D ARRAY :");
        int position1 = sc.nextInt();
        System.out.println("POSITION 2 ON 2D ARRAY :");
        int position2 = sc.nextInt();
        System.out.println("ELEMENT INSERT ON 2D ARRAY :");
        int element2d = sc.nextInt();

        insert2dArray(my2dArray, position1, position2, element2d);
        print2dArray(my2dArray);

        // DELETE 2D ARRAY
        System.out.println("POSITION 1 ON 2D ARRAY to delete :");
        int position3 = sc.nextInt();
        System.out.println("POSITION 2 ON 2D ARRAY to delete :");
        int position4 = sc.nextInt();
        delete2dArray(my2dArray, position3, position4);
        print2dArray(my2dArray);

        // UPDATE 2D ARRAY
        System.out.println("POSITION 1 ON 2D ARRAY to update :");
        int position5 = sc.nextInt();
        System.out.println("POSITION 2 ON 2D ARRAY to update :");
        int position6 = sc.nextInt();
        System.out.println("ELEMENT update ON 2D ARRAY :");
        int elementUdate2d = sc.nextInt();
        update2dArray(my2dArray, position5, position6,elementUdate2d);
        print2dArray(my2dArray);

        // // JAKE ARRAY 
        int my2dJakeArray[][] = new int[3][];
        System.out.println("CUSTOM ARRAY INSERT (N INSERT 1-D ARRAY):");
        int customSize=sc.nextInt();
        for (int i = 0; i < my2dJakeArray.length; i++) {
            my2dJakeArray[i]=new int [customSize];
            for (int j = 0; j < my2dJakeArray[i].length; j++) {
                System.out.print("ENTER THE ELEMNT " + j + ": ");
                my2dJakeArray[i][j] = sc.nextInt();
            }
            customSize--;
        }
        print2dArray(my2dJakeArray);

        sc.close();
    }

    // PRINT ARRAY
    public static void printArray(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    // UPDATE THE ARRAY
    public static void update(int arr[], int pos, int element) {
        int size = arr.length;
        if (pos >= 0 || pos > size - 1) {
            System.out.println("Wrong position");
            return;
        }
        arr[pos] = element;
    }

    // INSERTION ON THE ARRAY
    public static void insert(int arr[], int pos, int element) {
        int size = arr.length;
        if (pos >= 0 || pos > size - 1) {
            System.out.println("Wrong position");
            return;
        }
        // shifting towards the end
        for (int i = size - 2; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = element;
    }

    // deletion array
    public static void delete(int arr[], int pos) {
        // shifting towards starting index
        for (int i = pos; i <= arr.length - 2; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }

    // print 2d Array
    public static void print2dArray(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("For " + i + " index");
            printArray(arr[i]);
        }
    }

    // insert 2d Array in any position
    public static void insert2dArray(int arr[][], int pos1, int pos2, int element) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("For " + i + " index");
            insert(arr[pos1], pos2, element);
        }
    }

    // DELETE 2d Array in any position
    public static void delete2dArray(int arr[][], int pos1, int pos2) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("For " + i + " index");
            delete(arr[pos1], pos2);
        }
    }

    // UPDATE THE 2d ARRAY
    public static void update2dArray(int arr[][], int pos1,int pos2, int element) {
        int size1 = arr.length;
        if (pos1 >= 0 || pos1 > size1 - 1) {
            System.out.println("Wrong position 1");
            return;
        }
        int size2 = arr.length;
        if (pos2 >= 0 || pos2 > size2 - 1) {
            System.out.println("Wrong position 2");
            return;
        }
        arr[pos1][pos2] = element;
    }

    

}
