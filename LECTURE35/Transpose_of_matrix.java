package JAVA.SHASHCODE.LECTURE35;

public class Transpose_of_matrix {
    // static void transpose(int[][] matrix) {
    //     int Rows=matrix.length;
    //     int Cols=matrix[0].length;
    //     int n=Rows*Cols;
    //     for (int i=0;i<n;i++){
    //         for(int j=0;j<i;j++){
    //             swap(matrix,i,j);
    //         }
    //     }
    // }
    // static void swap(int matrix[][],int i,int j){
    //     int temp=matrix[i][j];
    //     matrix[i][j]=matrix[j][i];
    //     matrix[j][i]=temp;
    // }

    // // clock wise matrix rotation
    //  public void rotate(int[][] matrix) {
    //     int n=matrix.length;
    //     transpose(matrix,n);
    //     for(int i=0;i<n;i++){
    //         for (int j=0;j<n/2;j++){
    //             int temp=matrix[i][j];
    //             matrix[i][j]=matrix[i][n-1-j];
    //             matrix[i][n-1-j]=temp;
    //         }
    //     }
    // }
    // static void swap(int matrix[][],int i,int j){
    //     int temp=matrix[i][j];
    //     matrix[i][j]=matrix[j][i];
    //     matrix[j][i]=temp;
    // }
    // static void transpose(int matrix[][],int n){
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<i;j++){
    //             swap(matrix,i,j);
    //         }
    //     }
    // }


    // rotated matrix by 90 degree
    static void rotate(int mat[][]) {
        // Code Here
        int n=mat.length;
        transpose(mat,n);
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[n-1-i][j];
                mat[n-1-i][j]=temp;
            }
        }
    }
    static void swap(int matrix[][],int i,int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    static void transpose(int matrix[][],int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                swap(matrix,i,j);
            }
        }
    }
}
