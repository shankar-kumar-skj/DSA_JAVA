package JAVA.SHASHCODE.LECTURE136;

public class Reverse_String_two_pointer {
    public void reverseString(char[] s) {
        // // method 1 StringBuilder
        // StringBuilder reverse=new StringBuilder(new String(s)).reverse();
        // for(int i=0;i<s.length;i++){
        //     s[i]=reverse.charAt(i);
        // }

        // // method 2 2 pointer approach
        int n=s.length;
        int left=0;
        int right=n-1;
        while(left<right){
            // swap
            char ch=s[left];
            s[left]=s[right];
            s[right]=ch;
            left++;
            right--;
        }
    }
}
