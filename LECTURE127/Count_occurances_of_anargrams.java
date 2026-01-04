package JAVA.SHASHCODE.LECTURE127;

import java.util.Arrays;

public class Count_occurances_of_anargrams {
    int search(String pat, String txt) {
        // code here
        int patFreq[]=new int[26];
        int k=pat.length();
        int n=txt.length();

        // calc pattern frequency
        for(int i=0;i<k;i++){
            int index=pat.charAt(i)-'a';
            patFreq[index]++;
        }

        // init window
        int txtFreq[]=new int [26];
        for(int i=0;i<k;i++){
            int index=txt.charAt(i)-'a';
            txtFreq[index]++;
        }

        int count=0;
        if(Arrays.equals(txtFreq,patFreq)){
            count++;
        }
        
        // calc for other windows
        for(int i=1;i<n-k+1;i++){
            int removedCharIndex=txt.charAt(i-1)-'a';
            int addedCharIndex=txt.charAt(i+k-1)-'a';
            txtFreq[addedCharIndex]++;
            txtFreq[removedCharIndex]--;
            if(Arrays.equals(txtFreq,patFreq)){
            count++;
            }
        }
        return count;
    }
}
