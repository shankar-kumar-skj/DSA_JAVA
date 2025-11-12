package JAVA.SHASHCODE.LECTURE71;
import java.util.*;

// SET=> UNIQUES data
// keys of map => set (hash Code + key (default value))
//  set iterated using keys


public class Set_Interface {
    public static void main(String[] args) {
        // // no intertion order maintain using HashSet
        // Set<Integer> mySet=new HashSet<>();

        // // intertion order maintain using HashSet
        // Set<Integer> mySet=new LinkedHashSet<>();

        // // If we need to sort then use TreeSet
        // Set<Integer> mySet=new TreeSet<>();

        // If we need to sort then use TreeSet in reverse order
        Set<Integer> mySet=new TreeSet<>(Collections.reverseOrder());

        mySet.add(1);
        mySet.add(1);
        mySet.add(1);
        mySet.add(2);
        mySet.add(2); 
        System.out.println(mySet);
        // output=> 1,2

        mySet.add(3); 
        mySet.add(4); 
        mySet.add(5); 
        mySet.add(6); 
        mySet.add(7); 

        // check the value contain or not
        System.out.println(mySet.contains(1));

        // remove data
        System.out.println(mySet.remove(1));

        System.out.println(mySet);

        System.out.println(mySet.contains(1));

        Iterator<Integer> itrMySet= mySet.iterator();

        while(itrMySet.hasNext()){
            System.out.println(itrMySet.next());
        }
    }
}
