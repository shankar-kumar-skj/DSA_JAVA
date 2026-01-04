package JAVA.SHASHCODE.LECTURE126;

public class Longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        int windowStart=0;
        int windowEnd=0;
        int n=s.length();

        // hashSet method:-
        // HashSet<Character> set = new HashSet<>();
        // int maxLen=Integer.MIN_VALUE;
        // while(windowEnd<n){
        //     char ch=s.charAt(windowEnd);
        //     if(set.contains(ch)){
        //         // Shrinking 
        //         while(windowStart<windowEnd && set.contains(ch)){
        //             set.remove(s.charAt(windowStart));
        //             windowStart++;
        //         }
        //     }
        //     set.add(ch);
        //     maxLen=Math.max(maxLen,windowEnd-windowStart+1);
        //     windowEnd++;
        // }
        // return (maxLen==Integer.MIN_VALUE)?0:maxLen;


        // HashMap method:-
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen=Integer.MIN_VALUE;
        while(windowEnd<n){
            char ch=s.charAt(windowEnd);
            if(map.containsKey(ch) && map.get(ch)>=windowStart){
                // Shrinking 
                windowStart=map.get(ch)+1;
            }
            map.put(ch,windowEnd);
            maxLen=Math.max(maxLen,windowEnd-windowStart+1);
            windowEnd++;
        }
        return (maxLen==Integer.MIN_VALUE)?0:maxLen;
    }
}
