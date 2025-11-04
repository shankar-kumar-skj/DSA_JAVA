package JAVA.SHASHCODE.LECTURE70;

import java.util.Stack;

public class Longest_valid_parentheses {
    public int longestValidParentheses1(String s) {
        Stack<Integer> stack=new Stack<>();
        int max=0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push(i); // index
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }

    // using custom stack
    public int longestValidParentheses(String s) {
        int stack[]=new int[s.length()+1];
        int index=-1;
        int max=0;
        stack[++index]=-1;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack[++index]=i;
            }
            else{
                index--;
                if(index==-1){
                    stack[++index]=i;
                }
                else{
                max=Math.max(max,i-stack[index]);
                }
            }
        }
        return max;
    }
}
