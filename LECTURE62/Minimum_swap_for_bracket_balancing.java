package JAVA.SHASHCODE.LECTURE62;

public class Minimum_swap_for_bracket_balancing {
    public static void main(String[] args) {
        
    }
    static int minimumNumberOfSwaps(String s) {
        // code here
        int open=0;
        int close=0;
        int unbalanced=0;
        int swap=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='['){
                open++;
                if(unbalanced>0){
                    swap+=unbalanced;
                    unbalanced--;
                }
        }
        else{
            close++;
            unbalanced=close-open;
        }
        }
        return swap;
    }
}
