package JAVA.SHASHCODE.LECTURE32;

public class Median_in_a_row_wise_sorted_matrix {
    public int median(int[][] mat) {
        // code here
        int R = mat.length;          // Number of rows
        int C = mat[0].length;       // Number of columns 
        int N=R*C; // TOTAL ELEMENT
        int medianIndex=N/2;
        int start=1;
        int end=2000;

        while(start<=end){
            int assumedMedian=start+(end-start)/2;
            // no. of element less than assumed median
            // k-> lesserElement
            int lesserElements=findSmallerElements(mat,assumedMedian);
            if(lesserElements<=medianIndex){
                start=assumedMedian+1;
            }
            else{
                end=assumedMedian-1;
            }
        }
        return start;
    }

    int findSmallerElements(int matrix[][],int assumedMedian){
        int noOfSmallerElements=0;
        for (int i=0;i<matrix.length;i++){
            // matrix[i] -> 0,1,2
            // apply binary search on matrix[i]
            int start=0;
            int end=matrix[i].length-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(matrix[i][mid]<=assumedMedian){
                    start=mid+1;
                }
                else{
                    end =mid-1;
                }
            }
            // start
            noOfSmallerElements+=start;
        }
        return noOfSmallerElements;
    }
}
