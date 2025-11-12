package JAVA.SHASHCODE.LECTURE71;
import java.util.*;

public class Map_collection {
    public static void main(String[] args) {
        // // linkedhashMap => it maintained the interation order
        // Map<Integer,String> classMapLinkedList= new LinkedHashMap<>(); 
        
        Map<Integer,String> classMap= new HashMap<>();

        classMap.put(1,"E3");
        classMap.put(2,"MUMMUY");
        classMap.put(3,"BHASAYI");
        classMap.put(4,"KAMAL");
        classMap.put(5,"Shankar");
        System.out.println(classMap);
        classMap.put(5,"pulkit");
        System.out.println(classMap);
        classMap.putIfAbsent(5,"Shankar");
        System.out.println(classMap);

        System.out.println(classMap);

        System.out.println(classMap.get(4));
        System.out.println(classMap.get(7));

        // get or default message
        System.out.println(classMap.getOrDefault(7,"No value"));
        
        // check the key is avaliable or not!
        System.out.println(classMap.containsKey(7));

        // check the VALUE is avaliable or not!
        System.out.println(classMap.containsValue("E3"));
        
        // adding title at the last
        classMap.put(1,classMap.getOrDefault(1, "No data")+"jaiswal");
        
        // ENHANCED For loop
        // map=> interface 
        for(Map.Entry<Integer,String> entry : classMap.entrySet()){
            System.out.println("Key : "+ entry.getKey());
            System.out.println("Value : "+ entry.getValue());
        }

        // print keys only
        for(Integer key : classMap.keySet()){
            System.out.println("Key : "+ key);
        }

        // print values only
        for(String Value : classMap.values()){
            System.out.println("Value : "+ Value);
        }


    }
}
