package JAVA.SHASHCODE.LECTURE201;

import java.util.*;

public class Minimum_from_data_stream {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    
    public Minimum_from_data_stream() {
        minHeap = new PriorityQueue<>(); // incr
        maxHeap = new PriorityQueue<>((a,b)->(b-a)); // dec
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        // <=
        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek()>minHeap.peek()){
            int val=maxHeap.poll();
            minHeap.offer(val);
        }
        // size check
        if(maxHeap.size()>minHeap.size()+1){
            int val=maxHeap.poll();
            minHeap.offer(val);
        }
        if(minHeap.size()>maxHeap.size()+1){
            int val=minHeap.poll();
            maxHeap.offer(val);
        }
    }
    
    public double findMedian() {
        if(minHeap.size()>maxHeap.size()){
            return minHeap.peek();
        }
        else if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        else{
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }
}
