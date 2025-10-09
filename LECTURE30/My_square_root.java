package JAVA.SHASHCODE.LECTURE30;

public class My_square_root {
    public int mySqrt(int x) {
        int start=1;
        int end=x;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(mid<=x/mid){
                if(x%mid==0 && mid==x/mid){
                    return mid;
                }
                start=mid+1;
            }
            else end=mid-1;
        }
        return end;
    }
}
