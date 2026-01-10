package JAVA.SHASHCODE.LECTURE152;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// joespher problem

public class Find_the_winter_of_the_circular_game {
    public int findTheWinner(int n, int k) {

        // // USING ArrayList 
        // // TC => N + N^2
        // // SC => N
        // ArrayList<Integer> list = new ArrayList<>();
        // // O(N)
        // for (int i = 1; i <= n; i++) {
        //     list.add(i);
        // }
        // // O(N)
        // int index = 0;
        // while (list.size() > 1) {
        //     index = (index + (k - 1)) % list.size();
        //     // O(N)
        //     list.remove(index);
        // }
        // return list.get(0);

        

    //     // // USING Circular Queue  
    //     // // TC => N + (N*k)
    //     // SC => N
    //     Queue<Integer> queue = new LinkedList<>();
    //     // O(N)
    //     for (int i = 1; i <= n; i++) {
    //         queue.add(i);
    //     }
    //     while (queue.size() > 1) {
    //         // (k-1) rotation
    //         for(int i=0;i<k-1;i++){
    //             queue.offer(queue.poll());
    //         }
    //         queue.poll();
    //     }
    //     return queue.peek();


        // // // USING Recursion  
        // // // TC => N + (N*k)
        // // SC => N

        // int index=findIndex(n, k);
        // return index+1;

        // // USING Recursion with optimization
        // // TC => N
        // SC => 1
        int ans=0;
        for(int i=2;i<=n;i++){
            ans=(ans+k)%i;
        }
        return ans+1;
    }
    // public int findIndex(int n,int k){
    //     if(n==1){
    //         return 0;
    //     }
    //     return (findIndex(n-1, k)+k)%n;
    // }
}
