package JAVA.SHASHCODE.LECTURE225;

import java.util.*;

// Shortest path Algorithm
// BFS apply when :
// 1. Equal weight in each edge
// 2. no weight in edge
// 3. level wise equal weight distribution

// How to find shortest path on weighted graph ?
// => Dijkstra's
// => Floyd warshall
// => Bellmanford

// TC => O(V + E)
// SC => O(V) + O(V)

public class When_to_app_bfs_shortest_path_using_bfs_graph {
    public int[] shortestPath(int[][] edges,int n,int m,int src){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            int v=edge[0];
            int u=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        int dist[]=new int[n];
        Arrays.fill(dist,-1);
        dist[src]=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            for(int neighbour : adj.get(node)){
                if(dist[neighbour]==-1){
                    dist[neighbour]=dist[node]+1;
                    queue.offer(neighbour);
                }
            }
        }
        return dist;
    }
}
