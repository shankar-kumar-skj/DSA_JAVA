package JAVA.SHASHCODE.LECTURE61;

import java.util.Stack;

public class Minimum_no_of_swap_to_balance_string {
    public static void main(String[] args) {
        
    }
    public int minSwaps1(String s) {
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty() || stack.peek()==']'){
                    stack.push(ch);
                }
                else{
                    stack.pop();
                }
            }
        }
        int totalBrackets=stack.size();
        int closedBrackets=totalBrackets/2;
        return ((closedBrackets+1)/2);
    }
    public int minSwaps(String s) {
        int open=0;
        int close=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='['){
                open++;
            }
            else{
                if(open<=0){
                    close++;
                }
                else{
                    open--;
                }
            }
        }
        return ((close+1)/2);
    }
}
