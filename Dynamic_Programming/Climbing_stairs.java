package JAVA.SHASHCODE.Dynamic_Programming;

// import java.util.Arrays;

public class Climbing_stairs {
    // // base case
    // public int climbStairs(int n){
    //     // base case
    //     if(n<=2){
    //         return n;
    //     }
    //     return climbStrairs(n-1)+climbStrairs(n-2);
    // }

}


// // Top down approach DP :-
// class Solution{
//     // 2^n
//     public int climbStairs(int n){
//         int dp[]=new int[n+1];
//         Arrays.fill(dp,-1);
//         return recur(n, dp);

//     }

//     public int recur(int n,int dp[]){
//         // base case
//         if(n<=2){
//             dp[n]=n;
//             return n;
//         }
//         if(dp[n]!=-1){
//             return dp[n];
//         }
//         dp[n]= climbStrairs(n-1)+climbStrairs(n-2);
//         return dp[n];
//     }
// }


// Bottom Up approach DP :-
class Solution{
    // 2^n
    public int climbStairs(int n){
        if(n<=2){
            return n;
        }
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int state=3;state<=n;state++){
            dp[state] = dp[state-1]+dp[state-2];
        }
        return dp[n];
    }
}
// Bottom Up approach DP : -
class Solution_2{
    // 2^n
    public int climbStairs(int n){
        if(n<=2){
            return n;
        }
        int prev2=1;
        int prev1=2;
        int ans=0;
        for(int state=3;state<=n;state++){
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}