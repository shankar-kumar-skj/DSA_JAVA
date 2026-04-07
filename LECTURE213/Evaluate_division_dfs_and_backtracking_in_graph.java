package JAVA.SHASHCODE.LECTURE213;

import java.util.*;

// TC => O(M) + K*N
// SC => O(N) +O(N)

public class Evaluate_division_dfs_and_backtracking_in_graph {

    public double dfs(String src,String target,double product,HashSet<String> visited,HashMap<String,HashMap<String,Double>> map){
        double ret=-1;
        visited.add(src);
        if(map.get(src).containsKey(target)){
            ret=map.get(src).get(target)*product;
        }
        else{
            for(String neigbour: map.get(src).keySet()){
                if(!visited.contains(neigbour)){
                    ret=dfs(neigbour,target,map.get(src).get(neigbour)*product,visited,map);
                    if(ret!=-1){
                        break;
                    }
                }
            }
        }
        visited.remove(src);
        return ret;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> map=new HashMap<>();
        for(int i=0;i<equations.size();i++){
        String dividend=equations.get(i).get(0);
        String divisor=equations.get(i).get(1);
        double res=values[i];
        if(!map.containsKey(dividend)){
            map.put(dividend,new HashMap<String,Double>());
        }
        if(!map.containsKey(divisor)){
            map.put(divisor,new HashMap<String,Double>());
        }
        map.get(dividend).put(divisor,res);
        map.get(divisor).put(dividend,1/res);
        }
        double res[]= new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String dividend=queries.get(i).get(0);
            String divisor=queries.get(i).get(1);
            if(!map.containsKey(dividend) || !map.containsKey(divisor)){
                res[i]=-1.0;
            }
            else if(dividend.equals(divisor)){
               res[i] = 1.0;
            }
            else{
                HashSet<String> visited=new HashSet<>();
                res[i]=dfs(dividend,divisor,1,visited,map);
            }
        }
        return res;
    }
}
