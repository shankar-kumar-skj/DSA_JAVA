package JAVA.SHASHCODE.LECTURE133;

public class Minimum_length_of_string_after_deleting_similar_ends {
    public int minimumLength(String str) {
        int n=str.length();
        int p=0;
        int s=n-1;
        while(p<s && str.charAt(p)==str.charAt(s)){
            char ch=str.charAt(p);

            // del -prefix
            while(p<=s && str.charAt(p)==ch){
                p++;
            }
            // del -suffix
            while(p<=s && str.charAt(s)==ch){
                s--;
            }
        }
        return (s-p+1);
    }
}
