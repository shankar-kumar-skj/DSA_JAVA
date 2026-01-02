package JAVA.SHASHCODE.LECTURE115;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;

public class K_sum_subarray {
    public static void main(String[] args) {
        int arr[]={2,3,3,33,4,5,2,2,4,19,2,1};
        int k=23;
        boolean found=checkSumSubarray(arr,k);
        System.out.println("Found -> "+found);

        ArrayList<Integer> res=findKSumSubarray(arr,64);
        if (res.get(0)==-1){
            System.out.println("Not Found!");
            return;
        }
        System.out.println("Res -> ["+res.get(0)+","+res.get(1)+"]");
    }

    public static boolean checkSumSubarray(int arr[],int k) {
        HashSet<Integer> mySet=new HashSet<>();
        mySet.add(0);
        int sum=0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int rem=sum-k;
            if(mySet.contains(rem)){
                return true;
            }
            mySet.add(sum);
        }
        return false;
    }

    public static ArrayList<Integer> findKSumSubarray (int arr[],int k){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(-1); // no answer case
        HashMap<Integer,Integer> myMap = new HashMap<>();
        myMap.put(0,-1);
        int sum=0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int rem=sum-k;
            if(myMap.containsKey(rem)){
                int startingIndex=myMap.get(rem)+1;
                list.set(0,startingIndex);
                list.add(i);
                break;
            }
            myMap.put(sum,i);
        }
        return list;
    }

    public static int findLongestSumSubarray(int arr[],int k){
        int maxLen=0,sum=0;
        HashMap<Integer,Integer> myMap=new HashMap<>();
        myMap.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int rem=sum-k;
            if(myMap.containsKey(rem)){
                int len=i-myMap.get(rem);
                maxLen=Math.max(maxLen,len);
            }
            if(!myMap.containsKey(sum)){
                myMap.put(sum,i);
            }
        }
        return maxLen;
    }

    public static int findTotalKSumarray(int arr[],int k){
        int count=0,sum=0;
        HashMap<Integer,Integer> sumFreqMap = new HashMap<>();
        sumFreqMap.put(0,1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int rem=sum-k;
            count+=sumFreqMap.getOrDefault(rem, 0);
            sumFreqMap.put(sum,sumFreqMap.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
