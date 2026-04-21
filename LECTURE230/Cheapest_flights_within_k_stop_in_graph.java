package JAVA.SHASHCODE.LECTURE230;

import java.util.*;

// Bellman ford algorithm
//  => If a graph has N nodes then perform N-1 rounds of relaxation.
// Why N-1?
// (Because, At Max, there can be N-1 edges between two two nodes)

// if(d[u]+w<d[v]){
//      d[v]=d[u]+w;
// }

// If K steps: 
// Number of nodes = K+2
// Number of edges = K-1
// In this question rounds = K+1

// TC => O((K+1)*E)
// SC => O(2N)

public class Cheapest_flights_within_k_stop_in_graph {
    public int findCheapestPrice(int n,int[][] flights,int src,int dst, int k){
        // bellman ford
        int price[]=new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);
        price[src]=0;
        for(int i=0;i<k+1;i++){
            int temp[]=Arrays.copyOf(price, n); //values copy
            for(int flight[]:flights){
                int u=flight[0];
                int v=flight[1];
                int w=flight[2];
                if(price[u] != Integer.MAX_VALUE && price[u] + w <temp[v]){
                    temp[v]=price[u]+w;
                }
            }
            price = temp;
        }
        return (price[dst]==Integer.MAX_VALUE)?-1:price[dst];
    }

    // Dijkistra Algo
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
    // adjacency list
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] f : flights) {
        graph.computeIfAbsent(f[0], x -> new ArrayList<>())
             .add(new int[]{f[1], f[2]});
    }

    // min-heap: {cost, node, stops}
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.offer(new int[]{0, src, 0});

    // to track minimum stops to reach a node
    int[] stops = new int[n];
    Arrays.fill(stops, Integer.MAX_VALUE);

    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int cost = curr[0];
        int node = curr[1];
        int step = curr[2];

        // reached destination
        if (node == dst) return cost;

        // if stops exceed or not optimal, skip
        if (step > k || step > stops[node]) continue;

        stops[node] = step;

        if (graph.containsKey(node)) {
            for (int[] nei : graph.get(node)) {
                int next = nei[0];
                int price = nei[1];
                pq.offer(new int[]{cost + price, next, step + 1});
            }
        }
    }

    return -1;
}
}
