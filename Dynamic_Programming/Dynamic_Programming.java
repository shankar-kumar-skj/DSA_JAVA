package JAVA.SHASHCODE.Dynamic_Programming;

// Dynamic programming is a computer programming technique where an algorithmic
// problem is first broken down into sub-problems, the results are saved and then the
// sub-problems are optimized to find the overall solution.

// It applies to issues one can break down into either overlapping subproblems or 
// optimum substructures.

// 1. Optimal Substructure:

// Definition : 
// A problem exhibits optimal substructure if the solution to the 
// problem can be constructed efficiently from the solutions to its subproblems.

// Explanation: 
// This means that if you know how to solve smaller subproblems,
// you can use those solutions to build the solution to the larger problem.

// Example:
// In the shortest path problem (like Dijkstra's algorithm), the shortest 
// path from A to C through B is the sum of the shortest path A to B and the 
// shortest path from B to C. The oveall solution is constructed from the optimal 
// solutions to the subpaths.

// 2. Overlapping Subproblems:

// Definition : 
// A problem exhibits overlapping subproblems if the same 
// subproblems are solved multiple times when using a naive recursive approach.

// Explanation: 
// Rather than solving the same subproblem repeatedly, dynamic
// programming stores the result of each subprroblem in a table 
// (memorization or tabulation), and reuses it when needed, improving efficiency.

// Example:
// In the Fibonnacci sequence, to compute Fib(n), you recursively 
// calculate Fib(n-1) and Fib(n-2). However, Fib(n-1) also requires Fib(n-2) and 
// Fib(n-3), leading to redundant calculations.Dynamic Programming reduces
// this by storing the results of already calculated Fibonacci numbers.

// Key Concepts of DP :-

// 1. Memorization (Top-Down DP):
// We think about how we can divide the problem for case N into subproblems.

// 2. Tabulation (Bottom-Up DP):
// Involves solving the problem by starting from the smallest subproblems and building 
// up to the original problem.

// 3. State:
// A state defines the subproblem. For example, in a DP problem, the state might
// represent the current index or some other variable representing part of the input.

// 4. Transition:
// The transition is how the current state depends on previous states. 
// It defines how we moves from one subproblem to another.

public class Dynamic_Programming {
    
}


//              Memoization (Top-Down DP)
class FibonacciMemo {
    static int[] dp;

    static int fib(int n) {
        if (n <= 1)
            return n;

        if (dp[n] != -1)        // already calculated
            return dp[n];

        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
}
                // Tabulation (Bottom-Up)
class FibonacciTab {
    static int fib(int n) {
        if (n <= 1)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
    }
}
}