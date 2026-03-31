package JAVA.SHASHCODE.LECTURE204;

// import java.util.*;

// TC => O(E)
// SC => O(V)

public class Find_center_of_star_graph {
    // public int findCenter(int[][] edges) {
    //     HashMap<Integer,Integer> freqMap=new HashMap<Integer,Integer>();
    //     int totalEdges=edges.length;
    //     for(int i=0;i<edges.length;i++){
    //         int v1=edges[i][0];
    //         int v2=edges[i][0];
    //         freqMap.put(v1,freqMap.getOrDefault(v1, 0)+1);
    //         freqMap.put(v2,freqMap.getOrDefault(v2, 0)+1);
    //         if(freqMap.get(v1)==totalEdges){
    //             return v1;
    //         }
    //         if(freqMap.get(v2)==totalEdges){
    //             return v2;
    //         }
    //     }
    //     return -1;
    // }

    public int findCenter(int[][] edges) {
    int pair1[]=edges[0];
        int pair2[]=edges[1];
        if(pair1[0]==pair2[0]|| pair1[0]==pair2[1]){
            return pair1[0];
        }
        return pair1[1];
    }
}
