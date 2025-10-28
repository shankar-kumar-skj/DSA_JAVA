package JAVA.SHASHCODE.LECTURE55;

import java.util.Arrays;

public class Anagrams_in_two_string {
    public static boolean areAnagrams1(String a, String b) {
        // code here
        if(a.length()!=b.length()){
            return false;
        }
        char arrA[]=a.toCharArray();
        char arrB[]=b.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int indexA=0;
        int indexB=0;
        int len=a.length();
        while(indexA<len && indexB<len){
            if(arrA[indexA]!=arrB[indexB]){
                return false;
            }
            indexA++;
            indexB++;
        }
        return true;
    }

    public static boolean areAnagrams(String a, String b) {
        // code here
        if(a.length()!=b.length()){
            return false;
        }
        int freq[]=new int [26];
        int indexA=0;
        int indexB=0;
        int len=a.length();
        while(indexA<len && indexB<len){
            char charA=a.charAt(indexA);
            int freqIndexA=charA-97;

            freq[freqIndexA]+=1;
            char charB=b.charAt(indexB);
            int freqIndexB=charB-97;
            freq[freqIndexB]-=1;
            indexA++;
            indexB++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }


}
