package JAVA.SHASHCODE.LECTURE53;

public class Palindrom_in_string {
    public static void main(String[] args) {
        boolean res=checkPalindrom("NAMAN");
        System.out.println(res);
    }
    public static boolean checkPalindrom(String input1){
        String input=input1.toLowerCase();
        int start=0;
        int end=input.length()-1;
        while(start<end){
            if(input.charAt(start)!=input.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
