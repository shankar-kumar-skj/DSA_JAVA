package JAVA.SHASHCODE.LECTURE236;

import java.util.*;

// A Bipartite graph is a graph in which the vertices can be divided into two disjoint sets, such that no two vertices within the same set are adjacent.

// Graph is Bipartite graph if :
// (i) Not contain Cycle.
// (ii) contain Even Length Cycle.

// TC => V + O(V + E)
// SC => O(V) +O(V)

public class Is_graph_bipartite_linked_list {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!color(i,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean color(int src,int graph[][],int color[]){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(src);
        color[src] = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour : graph[node]){
                if(color[neighbour] == -1){
                    color[neighbour]=1-color[node];
                    queue.offer(neighbour);
                }
                else if(color[neighbour] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}
