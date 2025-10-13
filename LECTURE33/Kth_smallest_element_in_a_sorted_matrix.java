package JAVA.SHASHCODE.LECTURE33;

public class Kth_smallest_element_in_a_sorted_matrix {
    public int kthSmallest(int[][] mat, int k) {
        // code here
        int R = mat.length;          // Number of rows
        int C = mat[0].length;       // Number of columns 
        int N=R*C; // TOTAL ELEMENT
        int requiredSmallerElement=k-1; // N/2;
        int start=mat[0][0];
        int end=mat[R-1][C-1];

        while(start<=end){
            int assumedKthElement=start+(end-start)/2;
            // no. of element less than assumed median
            // k-> lesserElement
            int smallerElements=findSmallerElements(mat,assumedKthElement);
            if(smallerElements<=requiredSmallerElement){
                start=assumedKthElement+1;
            }
            else{
                end=assumedKthElement-1;
            }
        }
        return start;
    }

    int findSmallerElements(int matrix[][],int assumedKthElement){
        int noOfSmallerElements=0;
        for (int i=0;i<matrix.length;i++){
            // matrix[i] -> 0,1,2
            // apply binary search on matrix[i]
            int start=0;
            int end=matrix[i].length-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(matrix[i][mid]<=assumedKthElement){
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
