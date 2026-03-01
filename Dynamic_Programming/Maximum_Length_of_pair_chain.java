package JAVA.SHASHCODE.Dynamic_Programming;

import java.util.Arrays;

public class Maximum_Length_of_pair_chain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> a[0]-b[0]);
        int n=pairs.length;
        int lis[]= new int [n];
        Arrays.fill(lis,1);
        int maxLen=1;
        for(int i=1;i<n;i++){
            for(int p=0;p<i;p++){
                if(pairs[p][1]<pairs[i][0]){
                    lis[i] = Math.max(lis[i],1+lis[p]);
                }
            }
            if(lis[i]>maxLen){
                maxLen=lis[i];
            }
        }
        return maxLen;
    }
}
