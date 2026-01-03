package JAVA.SHASHCODE.LECTURE117;

import java.util.HashSet;

public class Longest_Consecutive_Subsequence {
    public int longestConsecutive(int[] nums) {
        // // using sorting and duplicates ignoring methods :-
        // if(nums.length==0){
        //     return 0;
        // }
        //     Arrays.sort(nums); //NlogN
        //     int maxLen=1;
        //     int prev=nums[0];
        //     int len=1;
        //     for(int i=1;i<nums.length;i++){
        //         if(prev==nums[i]){
        //             continue;
        //         }
        //         if(nums[i]==prev+1){
        //             len++;
        //         }
        //         else{
        //             len=1;
        //         }
        //         prev=nums[i];
        //         maxLen=Math.max(maxLen,len);
        //     }
        // return maxLen;

        // using HashSet
        int n=nums.length;
        if(n==0){
            return 0;
        }

        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int maxLen=0;
        for(Integer element:set){
            int prevEl=element-1;//0
            if(!set.contains(prevEl)){
                int len=1;
                int nextEl=element+1;
                while(set.contains(nextEl)){
                    len++; //2
                    nextEl++; //3
                }
                maxLen=Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}
