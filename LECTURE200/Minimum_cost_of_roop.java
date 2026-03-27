package JAVA.SHASHCODE.LECTURE200;

import java.util.*;

// TC => O(N + 3N log(N))

public class Minimum_cost_of_roop {
    public static int minCost(int[] arr){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int element : arr){
            minHeap.offer(element);
        }
        int cost=0;
        while(minHeap.size()>1){
            int rope1 = minHeap.poll();
            int rope2 = minHeap.poll();
            int newRope=rope1+rope2;
            cost+=newRope;
            minHeap.offer(newRope);
        }
        return cost;
    }
}
