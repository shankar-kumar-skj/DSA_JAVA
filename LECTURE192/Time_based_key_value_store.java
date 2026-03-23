package JAVA.SHASHCODE.LECTURE192;

import java.util.HashMap;
import java.util.TreeMap;

public class Time_based_key_value_store {
    HashMap<String,TreeMap<Integer,String>> map;
    public Time_based_key_value_store() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new TreeMap<>());
        }
        TreeMap<Integer,String> subMap =map.get(key);
        subMap.put(timestamp,value);
        // key -> time -> value
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        TreeMap<Integer,String> subMap =map.get(key);
        Integer prevTime=subMap.floorKey(timestamp);
        if(prevTime==null){
            return "";
        }
        return subMap.get(prevTime);
    }
}
