package JAVA.SHASHCODE.LECTURE17;

public class Searching {
    public static void main(String[] args) {
        int arr[]={2,2,3,4,1,7,2,9};

        linerSearch(arr, 3);

        linerSearchfinal(arr, 3, true);
        
        linerSearchMultiple(arr, 0, false);
        
        findMax(arr);
        
        findMaxUsingIntegerMinValue(arr);
        
        findMin(arr);
        
        findMinUsingIntegerMaxValue(arr);

        // creating 2D array of arr2d[4][5];
        int arr2d[][]={
            {2,4,1,5,1},
            {6,7,3,4,2},
            {8,1,2,2,3},
            {5,5,5,8,4}
        };
        linerSearch2d(arr2d, 34);
        linerSearch2dLast(arr2d, 34,false);
        linerSearch2dLast(arr2d, 34,true);
        
    }

    // element found ata starting
    public static void linerSearch(int arr[],int target){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                ans=i;
                break;
            }
        }
        if(ans==0){
            System.out.println("Not Found element at any position");
        }
        else{
            System.out.println("Found element at position : "+ ans);
        }
    }

    // last occurance data
    public static void linerSearchfinal(int arr[],int target,boolean findLast){
        int ans=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                ans=i;
                if(findLast==false){
                    break;
                }
            }
        }
        if(ans==-1){
            System.out.println("Not Found element at any position");
        }else{
            System.out.println("Found element at position : "+ ans);
        }
    }

    // multiple occurance data
    public static void linerSearchMultiple(int arr[],int target,boolean findLast){
        int ans[]=new int[arr.length];
        int k=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                arr[k]=i;
                k++;
            }
        }
        if(k==0){
            System.out.println("Not Found element at any position");
        }else{
           for(int i=0;i<ans.length;i++){
             System.out.println("Found element at position : "+ ans[i]);
           }
        }
    }

    // FIND MAXIMUM ELEMENT
    public static void findMax(int arr[]){
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        System.out.println("Maximum element is : "+max);
    }

    // FIND MAXIMUM ELEMENT
    public static void findMaxUsingIntegerMinValue(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        System.out.println("Maximum element is : "+max);
    }

    // FIND MAXIMUM ELEMENT
    public static void findMin(int arr[]){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("Minimum element is : "+min);
    }

    // FIND MINIMUM ELEMENT
    public static void findMinUsingIntegerMaxValue(int arr[]){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
            }
        }
        System.out.println("Minimum element is : "+min);
    }

    // INSERTION IN 2D ARRAY
    public static void linerSearch2d(int arr[][],int target){
        int outerIndex=-1;
        int InnerIndex=-1;
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if(target==arr[i][j]){
                    outerIndex=i;
                    InnerIndex=j;
                }
            }

        }
    }

    // last
    public static void linerSearch2dLast(int arr[][],int target,boolean findLast){
        int outerIndex=-1;
        int InnerIndex=-1;
        for(int i=0;i<arr.length;i++){
            boolean found=false;
            for (int j=0;j<arr[i].length;j++){
                if(target==arr[i][j]){
                    outerIndex=i;
                    InnerIndex=j;
                    if(findLast==false){
                        found=true;
                        break;
                    }
                }
            }
            if(found==true){
                break;
            }
            
        }
        if(outerIndex==0){
            System.out.println("Not Found element at any position");
        }else{
             System.out.println("Found element at position : "+ outerIndex+","+InnerIndex);
    }
}
}