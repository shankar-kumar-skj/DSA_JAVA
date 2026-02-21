package JAVA.SHASHCODE.Dynamic_Programming;

public class Rod_cutting_problem {
    // public int cutRod(int[] price) {
    // // code here
    // int N=price.length;
    // return recur(N, N-1, price);

    // }
    // int recur(int N,int index,int price[]){
    // if(index==0){
    // return N* price[index];
    // }
    // int pick=0;
    // int curLen=index+1;
    // if(N>=curLen){
    // pick = price[index] + recur(N- curLen, index, price);
    // }
    // int noPick = recur(N, index-1, price);
    // return Math.max(pick,noPick);
    // }

    // // // DP Top Down Approach
    // public int cutRod(int[] price) {
    // // code here
    // int N=price.length;
    // // (len, RodLen)
    // int dp[][]=new int [N][N+1];
    // for(int i=0;i<N;i++){
    // for(int j=0;j<N+1;j++){
    // dp[i][j]=-1;
    // }
    // }
    // return recur(N, N-1, price,dp);

    // }
    // int recur(int N,int index,int price[],int dp[][]){
    // if(index==0){
    // dp[index][N]=N* price[index];
    // return N* price[index];
    // }

    // if(dp[index][N]!=-1){
    // return dp[index][N];
    // }
    // int pick=0;
    // int curLen=index+1;
    // if(N>=curLen){
    // pick = price[index] + recur(N- curLen, index, price,dp);
    // }
    // int noPick = recur(N, index-1, price,dp);
    // dp[index][N]=Math.max(pick,noPick);
    // return dp[index][N];
    // }

    // // // DP Bottom Up Approach
    // public int cutRod(int[] price) {
    //     // code here
    //     int N = price.length;
    //     // (len, RodLen)
    //     int dp[][] = new int[N][N + 1];
    //     for (int r = 0; r < N + 1; r++) {
    //         dp[0][r] = r * price[0];
    //     }

    //     for (int i = 1; i < N; i++) {
    //         for (int j = 0; j < N + 1; j++) {
    //             int pick = 0;
    //             int curLen = i + 1;
    //             if (j >= curLen) {
    //                 pick = price[i] + dp[i][j-curLen];
    //             }
    //             int noPick = dp[i-1][j];
    //             dp[i][j] = Math.max(pick, noPick);
    //         }
    //     }
    //     return dp[N-1][N];
    // }

    // // DP Space Optimization Approach
    public int cutRod(int[] price) {
        // code here
        int N = price.length;
        // (len, RodLen)
        int prev[] = new int[N + 1];
        for (int r = 0; r < N + 1; r++) {
            prev[r] = r * price[0];
        }

        for (int i = 1; i < N; i++) {
            int cur[]= new int[N+1];
            for (int j = 0; j < N + 1; j++) {
                int pick = 0;
                int curLen = i + 1;
                if (j >= curLen) {
                    pick = price[i] + cur[j-curLen];
                }
                int noPick = prev[j];
                cur[j] = Math.max(pick, noPick);
            }
            prev=cur;
        }
        return prev[N];
    }
}
