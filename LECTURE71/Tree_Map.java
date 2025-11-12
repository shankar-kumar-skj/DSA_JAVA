package JAVA.SHASHCODE.LECTURE71;

import java.util.*;

// treeMap=> basically used for maintained sorted order
public class Tree_Map {
    public static void main(String [] args){
        Map<Integer,String> classTreeMap=new TreeMap<>();
        classTreeMap.put(1,"E3");
        classTreeMap.put(2,"MUMMUY");
        classTreeMap.put(3,"BHASAYI");
        classTreeMap.put(4,"KAMAL");
        classTreeMap.put(5,"Shankar");

        System.out.println(classTreeMap);

        // reverseOrder
        Map<Integer,String> classTreeMap2=new TreeMap<>(Collections.reverseOrder());
        classTreeMap2.put(1,"E3");
        classTreeMap2.put(2,"MUMMUY");
        classTreeMap2.put(3,"BHASAYI");
        classTreeMap2.put(4,"KAMAL");
        classTreeMap2.put(5,"Shankar");

        System.out.println(classTreeMap2);
    }
}
