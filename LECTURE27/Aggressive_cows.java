package JAVA.SHASHCODE.LECTURE27;

import java.util.Arrays;

public class Aggressive_cows {
    public int aggressiveCows(int[] stalls, int k) {
        // if not enough stalls then return 
        if(stalls.length<k){
            return -1;
        }
        Arrays.sort(stalls);
        int start=1;
        int n = stalls.length - 1;
        int end=stalls[n]-stalls[0];
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;  
            if(isAllocationPossible(stalls,mid,k)){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
    static boolean isAllocationPossible(int stalls[],int minDistance,int cows){
        int cowsCount=1;
        int lastCowDistance=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastCowDistance>=minDistance){
                cowsCount+=1;
                lastCowDistance=stalls[i];
            }
            if(cowsCount>cows){
                return true;
            }
        }
        return false;
    }
}
