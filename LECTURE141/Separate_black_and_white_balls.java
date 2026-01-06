package JAVA.SHASHCODE.LECTURE141;

public class Separate_black_and_white_balls {
    public long minimumSteps(String s) {
        int n=s.length();
        int last=0;
        long swapCount=0;
        for(int cur=0;cur<n;cur++){
            if(s.charAt(cur)=='1'){
                continue;
            }
            else{
                // whiteball
                swapCount+=(cur-last); //imaginary swaping
                last++;
            }
        }
        return swapCount;
    }
}
