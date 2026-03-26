package JAVA.SHASHCODE.LECTURE195;

import java.util.*;

// // Max Heap Priority Queue logic
// // TC => O(N) + Tlog(T)
// // SC => O(T) + O(T)

// class Number implements Comparable<Number>{
//     int element;
//     int freq;
//     Number(int element,int freq){
//         this.element=element;
//         this.freq=freq;
//     }
//     public int compareTo(Number that){
//         // max heap
//         return that.freq-this.freq; //dec order
//     }
// }

// public class Top_k_frequent_element {
//     public int[] topKFrequent(int[] nums, int k) {
//         PriorityQueue<Number>pq=new PriorityQueue<>();
//         HashMap<Integer,Integer> freqMap = new HashMap<>();
//         // find freq of all element
//         for(int element : nums){
//             freqMap.put(element,freqMap.getOrDefault(element, 0)+1);
//         }

//         // insert element in PQ
//         for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
//             Number number=new Number(entry.getKey(),entry.getValue());
//             pq.offer(number);
//         }
//         int res[]=new int[k];
//         int index=0;
//         while(index<k){
//             Number number=pq.poll();
//             res[index]=number.element;
//             index++;
//         }
//         return res;
//     }
// }

// Min Heap Priority Queue logic
class Number implements Comparable<Number>{
    int element;
    int freq;
    Number(int element,int freq){
        this.element=element;
        this.freq=freq;
    }
    public int compareTo(Number that){
        // // max heap
        // return that.freq-this.freq; //dec order
        // // min heap
        return this.freq-that.freq; //inc order
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Number>pq=new PriorityQueue<>();
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        // find freq of all element
        for(int element : nums){
            freqMap.put(element,freqMap.getOrDefault(element, 0)+1);
        }

        // insert element in PQ
        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            Number number=new Number(entry.getKey(),entry.getValue());
            pq.offer(number);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int res[]=new int[k];
        int index=0;
        while(index<k){
            Number number=pq.poll();
            res[index]=number.element;
            index++;
        }
        return res;
    }
}
