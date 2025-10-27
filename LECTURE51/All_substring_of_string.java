package JAVA.SHASHCODE.LECTURE51;

public class All_substring_of_string {
    public static void main(String[] args) {
        // total substring => n(n+1)/2 + 1 where1 denoted the empty string.("")
        // String s="abc"
        // => a => s[0,0] => substring(0,1)

        printAllSubstring("abc");

    }
    public static void printAllSubstring(String input){
        int n=input.length();
        for(int startIndex=0;startIndex<n;startIndex++){
            for(int endIndex=startIndex+1;endIndex<n;endIndex++){
                System.out.println(input.substring(startIndex,endIndex));
            }
        }
    }
}
