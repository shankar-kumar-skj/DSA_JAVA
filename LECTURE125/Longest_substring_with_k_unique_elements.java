package JAVA.SHASHCODE.LECTURE125;

// variable length sliding window
// TC => expansion + srink => O(N) + O(N) => O(2N) ~= O(N)
// SC => O(1)

public class Longest_substring_with_k_unique_elements {
    public int longestKSubstr(String s, int k) {
        // code here
        int n=s.length();
        int windowStart=0;
        int windowEnd=0;
        int len=0;
        int maxLen=Integer.MIN_VALUE;
        int freqHash[]=new int[26];
        int uniqueCharCount=0;
        while(windowEnd<n){
            int index=s.charAt(windowEnd)-97;
            if(freqHash[index]==0){
                uniqueCharCount++;
                freqHash[index]++;
            }
            else{
                freqHash[index]++;
            }
            if(uniqueCharCount==k){
                len=windowEnd-windowStart+1;
                maxLen=Math.max(maxLen,len);
            }

            // shrinking
            else if(uniqueCharCount>k){
                while (windowStart<windowEnd && uniqueCharCount>k) {
                    index=s.charAt(windowStart)-'a';
                    windowStart++;
                    freqHash[index]--;
                    if(freqHash[index]==0){
                        uniqueCharCount--;
                    }
                }
            }
            windowEnd++;
        }
        return (maxLen==Integer.MIN_VALUE)?-1:maxLen;   
    }
}
