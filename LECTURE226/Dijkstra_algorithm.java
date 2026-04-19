package JAVA.SHASHCODE.LECTURE226;

import java.util.*;

// Edsger Dijkistra
// Amsterdam
// Rotterdam -> Groningen

// Single Source Shortest Path Algorithm

// Relaxation 
// if(dist[u]+w <dist[v]){
//  dist[v]=dist[u] + w
// }

// Worst Case => O(N*N)

// Where we use Dijkstra Algorithm
// => Directed or Undirected Graph Both Workable
// => No negative weight
// => Greedy Algorithm

public class Dijkstra_algorithm {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        // [node,dist]
        PriorityQueue<int[]> pq =new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int p1[],int p2[]){
                return p1[1] - p2[1];
            }
        });
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[S]=0;
        pq.offer(new int[]{S,0});
        while(!pq.isEmpty()){
            int pair[]=pq.poll();
            int u=pair[0];
            int d=pair[1];
            if(d>dist[u]) continue;
            for(ArrayList<Integer> neighbour : adj.get(u)){
                int v=neighbour.get(0);
                int w=neighbour.get(1);
                if(dist[u] +w<dist[v]){
                    dist[v] = dist[u]+w;
                    pq.offer(new int[]{v,dist[v]});
                }
            }
        }
        return dist;
    }
}
