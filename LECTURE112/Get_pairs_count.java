package JAVA.SHASHCODE.LECTURE112;

import java.util.HashMap;

public class Get_pairs_count {
    // int countPairs(int arr[], int target) {
    //     // code here
    //     int n=arr.length;
    //     HashMap<Integer,Integer> freqMap=new HashMap<>();
    //     for(int i=0;i<n;i++){
    //         freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0)+1);
    //     }
    //     int res=0;
    //     for(int i=0;i<n;i++){
    //         if(arr[i]>target){
    //             continue;
    //         }
    //         int secondVal = target - arr[i];
    //         if(freqMap.getOrDefault(secondVal,0)>0){
    //             res +=freqMap.get(secondVal);
    //             freqMap.put(arr[i],freqMap.get(arr[i])-1);
    //             if(arr[i] == secondVal){
    //                 res -= 1;
    //             }
    //         }
    //     }
    //     return res;
    // }

    int countPairs(int arr[], int target) {
        // code here
        int res=0;
        int n=arr.length;
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for(int i=0;i<n;i++){
            // if(arr[i]>target){
            //     continue;
            // }
            int secondValue=target-arr[i];
            res+=freqMap.getOrDefault(secondValue,0);
            freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0)+1);
        }
        return res;
    }

}
