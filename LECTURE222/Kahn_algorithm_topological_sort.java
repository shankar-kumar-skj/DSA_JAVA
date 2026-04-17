package JAVA.SHASHCODE.LECTURE222;

import java.util.*;

// Topological Sort => 
// Linear ordering of vertices such that if there is an edge between u & v then u should apppear before v [u -> v]
// It is only possible in DAG (Directed Acyclic Graph)

// Not used  in undirected graph and cycle containing graph

// kahn's Algorithm (Topological using BFS)
// Intution => for all (u -> v) pairs, solve u first & then solve v.
// Ex => u -> v
//       t -> v
// solve, 'u' & 't' before solving 'v'

// TC => O(V+E) + O(E)
// SC => O(V) + O(V)

public class Kahn_algorithm_topological_sort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int indegree[]=new int[V];
        for(int u=0;u<adj.size();u++){
            for(int v:adj.get(u)){
                indegree[v]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }

        if(res.size() !=V){
            return new int[V];
        }
        
        int ans[]=new int[V];
        for(int i=0;i<V;i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}
