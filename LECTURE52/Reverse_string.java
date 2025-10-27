package JAVA.SHASHCODE.LECTURE52;

public class Reverse_string {
    public static void main(String[] args) {
        reverseString1("ABCDE");
        reverseString2("ABCDE");
        reverseString3("ABCDE");
    }
    // 1st method
    public static void reverseString1(String input){
        String ans="";
        for(int i=0;i<input.length();i++){
            ans=input.charAt(i)+ans;
        }
        System.out.println(ans);
    }
    
    // 2ND METHOD
    public static void reverseString2(String input){
        StringBuilder ans=new StringBuilder();
        int n=ans.length();
        for(int i=0;i<n/2;i++){
            char firstChar=ans.charAt(i);
            char lastChar=ans.charAt(n-1-i);
            ans.setCharAt(i, lastChar);
            ans.setCharAt(n-i-1, firstChar);
        }
        System.out.println(ans.toString());
    }

    // 3RD METHOD
    public static void reverseString3(String input){
        char ansArr[]=input.toCharArray();
        int n=ansArr.length;
        for(int i=0;i<n/2;i++){
            char firstChar=ansArr[i];
            char lastChar=ansArr[n-1-i];
            ansArr[i]=lastChar;
            ansArr[n-1-i]=firstChar;
        }
        for(int i=0;i<n;i++){
            System.out.print(ansArr[i]);
        }
    }

}
