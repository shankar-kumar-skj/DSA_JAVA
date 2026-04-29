package JAVA.SHASHCODE.LECTURE237;

import java.util.*;

// Kosaraju Algorithm
// Sort of the basis of finish time of DFS
// Create a transpose Adj (reverse the edge)
// Apply DFS & count the SCC (Strongly Connected Components)

// TC => O(N+N+E)

public class Strongly_connected_components_kosaraju_algorithm_graphs {
    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        for(Integer it: adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,adj,st);
            }
        }
        st.push(node);
    }

    private void dfsCount(int node,boolean[] vis, ArrayList<ArrayList<Integer>> adjT){
        vis[node]=true;
        for(Integer it: adjT.get(node)){
            if(!vis[it]){
                dfsCount(it,vis,adjT);
            }
        }
    }


    public int kosaraju (int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis=new boolean[V];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,adj,st);
            }
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            vis[i]=false;
            for(Integer it: adj.get(i)){
                adjList.get(it).add(i);
            }
        }
        int count=0;
        while(!st.isEmpty()){
            int node=st.peek();
            st.pop();
            if(!vis[node]){
                count++;
                dfsCount(node, vis, adjList);
            }
        }
        return count;
    }
}
