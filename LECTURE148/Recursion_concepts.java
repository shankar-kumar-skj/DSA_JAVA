package JAVA.SHASHCODE.LECTURE148;

// error => stack overflow error 

public class Recursion_concepts {
    // void function(){
    //     // Base case => recursion handle
    //     if(condition) return;

    //     // Recursion Case => recursion occur
    //     function();
    // }
    
}
class PrintNumberDemo{
    private void print(int n){
        if(n==0) return; // Base case
        print(n-1); // Recursive call
        // n-1 => transition stack
        // [f(n)= f(n-1)] => recursion relation
        System.out.println(n + " "); // Task after recursion
    }
    private void print1(int n){
        if(n==0) return; // Base case
        System.out.println(n + " "); // Task after recursion
        print1(n-1); // Recursive call
        // n-1 => transition stack
        // [f(n)= f(n-1)] => recursion relation
    }

    public static void main(String[] args) {
        PrintNumberDemo pn=new PrintNumberDemo();
        pn.print(5);
        pn.print1(5);
    }
}

class Solution {
    // Function to calculate factorial of a number.
    int factorial(int n) {
        // code here
        if(n==1) return 1;
        return n*factorial(n-1);
    }
}

class Solution1{
public int fib(int n) {
        // using recursion
        // base case
        if(n<=1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}