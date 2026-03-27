package JAVA.SHASHCODE.LECTURE199;

// 1. Find Frequency => HashMap
// 2. After each operation / know the max frequency => Max Heap Priority Queue. (task -> [Frequency ,Execution Time] where, (Execution Time = current time + cool down period))
// 3. Maintain the cool down period => Queue.

// Minimum Time

// TC => O(N) + Nlog(N) + Nlog(N) 
// SC => O(3N)

import java.util.*;

class Task implements Comparable<Task>{
    int frequency;
    int executionTime;
    Task(int f, int t){
        frequency=f;
        executionTime=t;
    }
    public int compareTo(Task that){
        return that.frequency-this.frequency;
    }
}

public class Task_scheduler {
    public int leastInterval(char[] tasks,int n){
        // freq
        HashMap<Character,Integer> freqMap=new HashMap<>();
        for(char ch: tasks){
            freqMap.put(ch,freqMap.getOrDefault(ch, 0)+1);
        }

        // insertion in Max Heap - PQ 
        PriorityQueue <Task> pq=new PriorityQueue<>();
        // insert tasks in pq
        for(Character ch : freqMap.keySet()){
            int freq = freqMap.get(ch);
            pq.offer(new Task(freq,0));
        }

        Queue<Task> queue=new LinkedList<>();
        int time=0;
        while(!queue.isEmpty() || !pq.isEmpty()){
            time++;
            // check if there is a task in pq & process it 
            if(!pq.isEmpty()){
                Task task = pq.poll();
                task.frequency--;
                if(task.frequency>0){
                    // update the execution time
                    task.executionTime=time+n;
                    queue.offer(task);
                }
            }

            // shift the active process to the pq
            if(!queue.isEmpty() && queue.peek().executionTime==time){
                pq.offer(queue.poll());
            }
        }
        return time;
    }
}
