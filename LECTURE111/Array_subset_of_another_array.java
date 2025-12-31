package JAVA.SHASHCODE.LECTURE111;

import java.util.HashMap;

public class Array_subset_of_another_array {
    public boolean isSubset(int a[], int b[]) {
        // Your code here
      
        HashMap<Long,Integer> freqMap = new HashMap<>();
        for(long element : a){
            freqMap.put(element,freqMap.getOrDefault(element,0)+1);
        }
        for(long element : b){
            // if(freqMap.containsKey(element) && freqMap.get(element)>0){
            if(freqMap.getOrDefault(element,0)>0){
                freqMap.put(element,freqMap.get(element)-1);
            }
            else{
                return false;
            }
            
        }
        return true;
    }
}
