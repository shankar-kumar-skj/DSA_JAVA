package JAVA.SHASHCODE.LECTURE113;

import java.util.HashSet;
import java.util.Iterator;
// hashset is based on hashmap data structure
// hashest contains key and value
// keys are unique 
// values of all is same and constant
public class HashSet_concept {
    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>();
        set.add(4);
        set.add(6);
        System.out.println(set);
        set.add(6);
        System.out.println(set.contains(4));
        System.out.println(set.remove(4));
        System.out.println(set);

        // iteration
        for(Integer i:set){
            System.out.println(i);
        }

        // // remove function not work
        // for(Integer i:set){
        //     System.out.println(i);
        //     set.remove(i);
        // }

        // Iterator 
        // => no add
        // => no move backward
        Iterator<Integer> itr=set.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
            itr.remove();
        }
    }
}
