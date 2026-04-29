package JAVA.SHASHCODE.LECTURE239;

import java.util.*;

// Prim's Algorithm
// => Always start with any random vertex
// => Act Greedy & pick the minimum & connected Edge.
// (We can find th minimum edge weight sum as well as edges considered).

// TC => ElogE + VlogV

public class Prism_Algorithm_minimum_spanning_tree {
    static int spanningTree (int V, int E, List<List<int[]>> adj){
        // (parent, node, weight)
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<>() {
            public int compare(int pair1[],int pair2[]){
                return pair1[2]-pair2[2];
            }
        });
        int sum=0;
        ArrayList<int[]> edges = new ArrayList<>();
        boolean visited[] = new boolean[V];
        pq.offer(new int[]{-1,0,0});
        while(!pq.isEmpty()){
            int object[]= pq.poll();
            int parent = object[0];
            int node = object[1];
            int weight = object[2];
            if(visited[node]) continue;
            visited[node] = true;
            if(parent!=-1){
                edges.add(new int[]{parent,node});
                sum+=weight;
            }
            for(int neighbourObject[]: adj.get(node)){
                int neighbourNode = neighbourObject[0];
                int neighbourWeight = neighbourObject[1];
                if(!visited[neighbourNode]){
                    pq.offer(new int[]{node, neighbourNode, neighbourWeight});
                }
            }
        }
        return sum;
    }
}

class Solution {

    public int spanningTree(int V, int[][] edges) {
        
        // Step 1: Build adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // edges[i] = {u, v, w}
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w}); // undirected graph
        }

        // Step 2: Prim’s Algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        boolean[] visited = new boolean[V];
        int sum = 0;

        // {parent, node, weight}
        pq.offer(new int[]{-1, 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int parent = cur[0];
            int node = cur[1];
            int weight = cur[2];

            if (visited[node]) continue;

            visited[node] = true;
            sum += weight;

            for (int[] nei : adj.get(node)) {
                int nextNode = nei[0];
                int nextWeight = nei[1];

                if (!visited[nextNode]) {
                    pq.offer(new int[]{node, nextNode, nextWeight});
                }
            }
        }

        return sum;
    }
}
