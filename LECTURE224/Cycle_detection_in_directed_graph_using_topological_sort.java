package JAVA.SHASHCODE.LECTURE224;

import java.util.*;

// Topological Sort -> DAG
// => If a graph cannot be represented in topological order then there can be two reason :-
// 1. Graph is undirected.
// 2. Graph has Cycle.

// => If graph is directed, then only one reason 
// 1.) Graph has Style

// => How to find if a directed graph has Cycle?
// => Apply Topological Sort, if Topological Sort cannot be generated, then graph is said to have a cycle!




public class Cycle_detection_in_directed_graph_using_topological_sort {
    boolean topoSort(int V,ArrayList<ArrayList<Integer>> adj){
        int indegree[]=new int[V];
        for(int u=0;u<adj.size();u++){
            for(int v: adj.get(u)){
                indegree[v]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        ArrayList<Integer> res=new ArrayList<>();
        while(!queue.isEmpty()){
            int node=queue.poll();
            res.add(node);
            for(int neighbour: adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }

        if(res.size() != V){
            return true;
        }
        return false;
    }

    public boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
        return topoSort(V, adj);
    }
}
