package JAVA.SHASHCODE.LECTURE220;

import java.util.*;

// TC => O(N) + O(N)
// SC => O(N) + O(N)

public class Cycle_detection_in_undirected_graph_using_dfs {
    public boolean checkIfCycle(int src,int parent,ArrayList<ArrayList<Integer>> adj,boolean visited[]){
        visited[src]=true;
        for(int neighbour: adj.get(src)){
            if(neighbour==parent) continue;
            if(visited[neighbour]){
                return true;
            }
            else{
                if(checkIfCycle(neighbour,src,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
        // code here
        boolean visited[]=new boolean[V]; // false
        for(int i=0;i<V;i++){
            if(!visited[i] && checkIfCycle(i,-1,adj,visited)){
                return true;
            }
        }
        return false;
    }
}
