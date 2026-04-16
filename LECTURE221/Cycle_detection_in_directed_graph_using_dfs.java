package JAVA.SHASHCODE.LECTURE221;

import java.util.*;

// TC => 2 O(V)
// SC => 2 O(V)

public class Cycle_detection_in_directed_graph_using_dfs {
    public boolean checkIfCycle(int src, boolean visited[],ArrayList<ArrayList<Integer>> adj,boolean pathVisited[]){
        visited[src]=true;
        pathVisited[src]=true;

        // dfs
        for(int neighbour : adj.get(src)){
            if(pathVisited[neighbour]){
                return true;
            }
            else if(visited[neighbour]){
                continue;
            }
            else{
                if(checkIfCycle(neighbour, visited, adj, pathVisited)){
                    return true;
                }
            }
        }
        pathVisited[src]=false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill adjacency list (undirected graph)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[V];
        boolean pathVisited[]=new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkIfCycle(i, visited,adj,pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
