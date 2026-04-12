package JAVA.SHASHCODE.LECTURE219;

import java.util.*;

public class Detect_a_cycle_in_undirected_graph {
    public boolean checkIfCycle(int src,ArrayList<ArrayList<Integer>> adj,boolean visited[]){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{src,-1});
        visited[src]=true;
        while(!queue.isEmpty()){
            int pair[]=queue.poll();
            int node=pair[0];
            int parent=pair[1];
            for(int neighbour : adj.get(node)){
                if(neighbour==parent) continue;
                if(visited[neighbour]) return true;
                else{
                    queue.offer(new int[]{neighbour,node});
                    visited[neighbour]=true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill adjacency list (undirected graph)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkIfCycle(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
