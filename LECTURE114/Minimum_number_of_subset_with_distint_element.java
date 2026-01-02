package JAVA.SHASHCODE.LECTURE114;

import java.util.HashMap;
import java.util.HashSet;

public class Minimum_number_of_subset_with_distint_element {
    public static void main(String[] args) {
        int arr[]={2,1,4,1,6,5,5,5};
        int res=findMinNumberOfSets(arr);
        System.out.println("Min number of subset -> "+res);
        int res1=findMinNumberOfSetsBetter(arr);
        System.out.println("Min number of subset -> "+res1);
    }

    public static int findMinNumberOfSets(int arr[]){
        int res=0;
        int n=arr.length;
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }
            res++;
            HashSet<Integer> set=new HashSet<>();
            for(int j=i;j<n;j++){
                if(visited[j]|| set.contains(arr[j])){
                    continue;
                }
                visited[j]=true;
                set.add(arr[j]);
            }
        }
        return res;
    }

    // // better approach : -
    // // maximum frequency map 
    public static int findMinNumberOfSetsBetter(int arr[]){
        int maxFreq=0;
        int n=arr.length;
        HashMap<Integer,Integer> freqMap=new HashMap<>();

        for(int i=0;i<n;i++){
            freqMap.put(arr[i],freqMap.getOrDefault(arr[i], 0)+1);
            maxFreq=Math.max(maxFreq,freqMap.get(arr[i]));
        }
        return maxFreq;
    }
}
