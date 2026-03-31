package JAVA.SHASHCODE.LECTURE205;

import java.util.*;

// importance => sum of values of two cities connected.

// Max degree to become the value maximum

// TC => O(E) + V log(V) + O(V)
// SC => O(V)

public class Maximum_total_importance_of_roads {
    public long maximumImportance(int n, int[][] roads) {
        long degree[] = new long[n];
        for(int edges[] : roads){
            degree[edges[0]]++;
            degree[edges[1]]++;
        }
        Arrays.sort(degree);
        long res=0;
        for(int i=0;i<n;i++){
            res=res+(i+1)*degree[i];
        }
        return res;
    }
}
