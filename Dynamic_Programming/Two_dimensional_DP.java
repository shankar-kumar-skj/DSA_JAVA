package JAVA.SHASHCODE.Dynamic_Programming;

public class Two_dimensional_DP {

    // Recursion
    // public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
    //     // code here
    //     return recur(arr, K, N-1);
    // }
    // public static boolean recur(int arr[], int k, int index){
    //     if(k==0){
    //         return true;
    //     }
    //     if(index ==0){
    //         if(k==arr[index]){
    //             return true;
    //         }
    //         return false;
    //     }
    //     boolean pick=false;
    //     if(arr[index]<=k){
    //         pick=recur(arr, k-arr[index], index-1);
    //         if(pick){
    //             return true;
    //         }
    //     }
    //     boolean noPick = recur(arr, k, index-1);

    //     return noPick;
    // }
    
    // public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
    //     int dp[][] = new int[N][K+1];
    //     return recur(arr, K, N-1,dp);
    // }

    // // 0 => not visited
    // // 1 => true
    // // 2 => false

    // public static boolean recur(int arr[], int k, int index,int dp[][]){
    //     if(k==0){
    //         dp[index][k]=1;
    //         return true;
    //     }
    //     if(index ==0){
    //         if(k==arr[index]){
    //             dp[index][k]=1;
    //             return true;
    //         }
    //         dp[index][k]=2;
    //         return false;
    //     }

    //     if(dp[index][k]!=0){
    //         return (dp[index][k]==1);
    //     }

    //     boolean pick=false;
    //     if(arr[index]<=k){
    //         pick=recur(arr, k-arr[index], index-1,dp);
    //         if(pick){
    //             dp[index][k]=1;
    //             return true;
    //         }
    //     }
    //     boolean noPick = recur(arr, k, index-1,dp);
    //     dp[index][k]=(noPick==true)?1:2;
    //     return noPick;
    // }
    
    
    // public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
    //     int dp[][] = new int[N][K + 1];
    //     for (int i = 0; i < N; i++) {
    //         dp[i][0] = 1;
    //     }
    //     for (int t = 1; t <= K; t++) {
    //         if (t == arr[0]) {
    //             dp[0][t] = 1;
    //         } else {
    //             dp[0][t] = 2;
    //         }
    //     }
    //     for (int i = 1; i < N; i++) {
    //         for (int j = 1; j <= K; j++) {
    //             int pick = 2;
    //             if (arr[i] <= j) {
    //                 pick = dp[i-1][j-arr[i]];
    //                 if (pick==1) {
    //                     dp[i][j] = 1;
    //                     continue;
    //                 }
    //             }
    //             int noPick = dp[i-1][j];
    //             dp[i][j] = noPick ;
    //         }
    //     }
    //     return (dp[N-1][K]==1);
    // }
   
    
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        int prev[]=new int[K+1];
        prev[0]=1;
        for (int t = 1; t <= K; t++) {
            if (t == arr[0]) {
                prev[t] = 1;
            } else {
                prev[t] = 2;
            }
        }
        for (int i = 1; i < N; i++) {
            int curr[]=new int[K+1];
            curr[0]=1;
            for (int j = 1; j <= K; j++) {
                int pick = 2;
                if (arr[i] <= j) {
                    pick = prev[j-arr[i]];
                    if (pick==1) {
                        curr[j] = 1;
                        continue;
                    }
                }
                int noPick = prev[j];
                curr[j] = noPick ;
            }
            prev=curr;
        }
        return (prev[K]==1);
    }
   


}