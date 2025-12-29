package JAVA.SHASHCODE.Dynamic_Programming;

// https://leetcode.com/problems/fibonacci-number/

public class Fibonacci_Number {
    public static void main(String[] args) {
        
    }
    // time complexity => O(2^n) (recursion)
    // time complexity => O(n) (dynamic problem)

    public int fib(int n) {
        // // using recursion
        // // base case
        // if(n<=1){
        //     return n;
        // }
        // return fib(n-1) + fib(n-2);


        // // // using dynamic problem method 1
        // int dp[] =new int[n+1];
        // Arrays.fill(dp,-1);
        // return recur(n,dp);

        // // // using dynamic problem method 2 bottom up approach 
        // // // space complexity => O(n) (dynamic problem)

        // if(n<=1){
        //     return n;
        // }
        // int dp[] =new int[n+1];

        // // BASE CASE
        // dp[0]=0;
        // dp[1]=1;

        // for(int state=2;state<=n;state++){
        //     dp[state] = dp[state-1] + dp[state-2];
        // }

        // return dp[n];


        // // using dynamic problem method 3 the previous sum
        // // space complexity => O(n) (dynamic problem)

        if(n<=1){
            return n;
        }

        // BASE CASE
        int prev2=0;
        int prev1=1;
        int ans=0;

        for(int state=2;state<=n;state++){
            ans=prev1 + prev2;
            prev2=prev1;
            prev1=ans;
        }
        return ans;
    }

    // public int recur(int n,int dp[]) {
    //     // base case
    //     if(n<=1){
    //         dp[n]=n;
    //         return dp[n];
    //     }

    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }

    //     dp[n]=fib(n-1) + fib(n-2);
    //     return dp[n];
    // }
}
