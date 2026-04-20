package JAVA.SHASHCODE.LECTURE228;

import java.util.*;

// Bellman Ford
// => Single source shortest path
// => can detect negative cycles.
// => works on directed graphs.

// Steps:
// => for a graph of N nodes, do N-1 relaxation
// => the (N-1)th relaxation gives the shortest path.
// => if the Nth relaxation further reduces the SP, then the graph as Negative cycle.

// Relaxation => N node then (N-1) Relaxation
// => Process of updating the shortest path from source to other vertex.
// => distance array is updated, if a shorter path is found.

// Hth iteration => Negative Cycle

// TC => O(V*E)
// Sc => O(V)

public class Bellmanford_algorithm {
    static int[] bellman_ford(int V,ArrayList<ArrayList<Integer>> edges, int S){
        int dist[] = new int [V];
        Arrays.fill(dist,(int)1e8);
        dist[S]=0;
        for(int i=0;i<V-1;i++){
            boolean isChanges=false;
            for(ArrayList<Integer> edge : edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                if(dist[u] !=(int) 1e8 && dist[u]+w<dist[v]){
                    dist[v] = dist[u] + w;
                    isChanges=true;
                }
            }
            if(!isChanges){
                break;
            }
        }

        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> edge : edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                if(dist[u] !=(int) 1e8 && dist[u]+w<dist[v]){
                    return new int[]{-1};
                }
            }
        }
        return dist;
    }
}
