package JAVA.SHASHCODE.LECTURE207;

import java.util.*;

// TC => O(V+E)
// SC => O(V) +O(V)

public class Depth_first_search {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int V = adj.size();
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited,adj,res);
            }
        }
        return res;
    }

    public void dfs(int node, boolean visited[],ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res){
        visited[node]=true;
        res.add(node);
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, visited, adj, res);
            }
        }
    }
}
