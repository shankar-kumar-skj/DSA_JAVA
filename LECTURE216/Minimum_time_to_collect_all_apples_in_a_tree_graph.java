package JAVA.SHASHCODE.LECTURE216;

// TC => O(N-1) + O(N)
// SC => N*(N-1) + O(N)

import java.util.*;


public class Minimum_time_to_collect_all_apples_in_a_tree_graph {
    public int dfs(int src,int parent,List<List<Integer>> adjList,List<Boolean> hasApple){
    int totalTime=0;
    for(int neighbour:adjList.get(src)){
        if(neighbour == parent){
            continue;
        }
        int timeTakenByChild=dfs(neighbour,src,adjList,hasApple);
        if(timeTakenByChild>0 || hasApple.get(neighbour)){
            totalTime += timeTakenByChild + 2;
        }
    }
    return totalTime;
}

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        // adj list
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int from =edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        return dfs(0,-1,adjList,hasApple);
    }
}
