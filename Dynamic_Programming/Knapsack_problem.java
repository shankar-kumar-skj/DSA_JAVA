package JAVA.SHASHCODE.Dynamic_Programming;

public class Knapsack_problem {

    // RECURSION APPROACH
    // static int knapsack(int W, int val[], int wt[]) {
    //     // code here
    //     int n= val.length;
    //     return recur(W,val,wt,n-1);
    // }
    // static int recur(int capacity, int val[],int wt[],int index){
    //     // base case
    //     if(capacity == 0) return 0;
    //     if(index == 0){
    //         if(wt[index]<=capacity){
    //             return val[index];
    //         }
    //         else{
    //             return 0;
    //         }
    //     }
    //     int pick=0;
    //     if(wt[index]<=capacity){
    //         pick=val[index]+ recur(capacity-wt[index],val,wt,index-1);
    //     }
    //     int noPick=recur(capacity,val,wt,index-1);

    //     return Math.max(pick,noPick);
    // }


    // // Top down DP
    // static int knapsack(int W, int val[], int wt[]) {
    //     // code here
    //     int n= val.length;
    //     int dp[][]=new int [n][W+1];
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<W+1;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     return recur(W,val,wt,n-1,dp);

    // }
    // static int recur(int capacity, int val[],int wt[],int index,int dp[][]){
    //     // base case
    //     if(capacity == 0) {
    //         dp[index][capacity]=0;
    //         return 0;
    //     }
    //     if(index == 0){
    //         if(wt[index]<=capacity){
    //             dp[index][capacity]=val[index];
    //             return val[index];
    //         }
    //         else{
    //             dp[index][capacity]=0;
    //             return 0;
    //         }
    //     }
    //     if(dp[index][capacity]!=-1){
    //         return dp[index][capacity];
    //     }
    //     int pick=0;
    //     if(wt[index]<=capacity){
    //         pick=val[index]+ recur(capacity-wt[index],val,wt,index-1,dp);
    //     }
    //     int noPick=recur(capacity,val,wt,index-1,dp);
    //     dp[index][capacity]=Math.max(pick,noPick);
    //     return dp[index][capacity];
    // }
    
    // // BOTTOM UP DP
    // public int knapsack(int W, int val[], int wt[]) {
    //     // code here
    //     int n = val.length;
    //     int dp[][] = new int[n][W + 1];
    //     for (int i = 0; i < n; i++) {
    //         dp[i][0] = 0;
    //     }
    //     for (int c = 0; c < W+1; c++) {
    //         if (wt[0] <= c) {
    //             dp[0][c] = val[0];
    //         } else {
    //             dp[0][c] = 0;
    //         }
    //     }

    //     for (int i = 1; i < n; i++) {
    //         for (int j = 0; j < W + 1; j++) {
    //             int pick = 0;
    //             if (wt[i] <= j) {
    //                 pick = val[i] + dp[i-1][j-wt[i]];
    //             }
    //             int noPick = dp[i-1][j];
    //             dp[i][j] = Math.max(pick, noPick);
    //         }
    //     }
    //     return dp[n-1][W];
    // }
    
     // DP with Space optimize
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int prev[] = new int[W + 1];
        prev[0] = 0;
        for (int c = 0; c < W+1; c++) {
            if (wt[0] <= c) {
                prev[c] = val[0];
            } else {
                prev[c] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            int cur[] = new int[W + 1];
            cur[0] = 0;
            for (int j = 1; j < W + 1; j++) {
                int pick = 0;
                if (wt[i] <= j) {
                    pick = val[i] + prev[j - wt[i]];
                }
                int noPick = prev[j];
                cur[j] = Math.max(pick, noPick);
            }
            prev=cur;
        }
        return prev[W];
    }

}
