package JAVA.SHASHCODE.LECTURE223;

import java.util.*;

// TC => O(3V + E)
// SC => O(3V)

public class Topological_sort_using_dfs_graph {
    public static void dfs(int src, ArrayList<ArrayList<Integer>> adj,boolean visited[],Stack<Integer> stack){
        visited[src] = true;
        for(int neighbour : adj.get(src)){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited, stack);
            }
        }
        stack.push(src);
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        boolean visited[]=new boolean[V];
        Stack<Integer> stack =new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,adj,visited,stack);
            }
        }
        int index=0;
        int res[]=new int[V];
        while(!stack.isEmpty()){
            res[index]=stack.pop();
            index++;
        }
        return res;
    }

    
}
