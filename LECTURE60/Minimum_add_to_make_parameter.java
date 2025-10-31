package JAVA.SHASHCODE.LECTURE60;

import java.util.Stack;

public class Minimum_add_to_make_parameter {
    public static void main(String[] args) {
        
    }
    public int minAddToMakeValid1(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push('(');
            }
            else{
                if(stack.isEmpty()|| stack.peek()==')'){
                    stack.push(ch);
                }
                else{
                    stack.pop();
                }
            }
        }
        return stack.size();
    }

    public int minAddToMakeValid(String s) {
        int open=0, close=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
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
        return open+close;
    }
}
