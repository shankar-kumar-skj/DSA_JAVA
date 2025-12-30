package JAVA.SHASHCODE.LECTURE109;

import JAVA.SHASHCODE.LECTURE109.*;

public class Called_class {
    public static void main(String[] args) {
        MyHashMap<Integer,String> myMap=new MyHashMap<>();
        myMap.put(1,"E3");
        myMap.put(2,"SHANKAR");
        myMap.put(3,"PULKIT");
        System.out.println(myMap.get(2));
        myMap.put(2,"SKJ");
        System.out.println(myMap.get(2));
        System.out.println(myMap.isEmpty());
        System.out.println(myMap.containsKey(1));
        System.out.println(myMap.containsKey(5));

        myMap.iterate();

        myMap.containsValue("E3");
        myMap.containsValue("SKJ");

        System.out.println(myMap.remove(5));

        System.out.println(myMap.size());

        myMap.iterate();
    }
}
