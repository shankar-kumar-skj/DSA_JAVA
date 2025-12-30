package JAVA.SHASHCODE.LECTURE108;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import JAVA.SHASHCODE.LECTURE109.MyHashMap;

// hashmap => data structure that store key and value pair.
// keys are unique
// not follows any insertion order

// Insertion, search , deletion, updation => O(alpha) , where alpha is a load factor.

// key => value
// 1 => "skj"


class MyCollege{
    int regNo;
    private int hashCode;
    MyCollege(int regNo){
        this.regNo=regNo;  
        this.hashCode=Objects.hashCode(regNo);  
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        MyCollege college = (MyCollege) obj;
        return this.regNo == college.regNo;
    }
}

class MyRanking {
    int rank;
    MyRanking(int rank){
        this.rank=rank;
    }

    @Override
    public String toString() {
        return ""+this.rank;
    }

    @Override
    public boolean equals(Object obj) {
        MyRanking r = (MyRanking) obj;
        return this.rank == r.rank;
    }
}

public class Hashmap {
    public static void main(String[] args) {
        // HashMap<Integer,String> myMap=new HashMap<>();
        MyHashMap<Integer,String> myMap=new MyHashMap<>();

        // put
        myMap.put(1,"E3");
        myMap.put(2,"skj");
        myMap.put(3,"srishti");
        myMap.put(4,"shankar");
        System.out.println(myMap);
        myMap.put(3,"Madam ji");
        System.out.println(myMap);

        // get
        System.out.println(myMap.get(1));
        System.out.println(myMap.get(3));
        
        // containsKey => element is exit in boolean form
        System.out.println(myMap.containsKey(1));

        // // getOrDefault => if value exist print value otherwise return message
        // System.out.println(myMap.getOrDefault(1,"always with me"));

        // // replace => to update the value
        // myMap.replace(4, "shankarwa");
        // System.out.println(myMap);

        // // entrySet() to return all value
        // for(Map.Entry<Integer,String> entry: myMap.entrySet()){
        //     System.out.println("Key -> "+entry.getKey());
        //     System.out.println("Value -> "+entry.getValue());
        // }
        
        // // KeySet() to return all value
        // for(Integer key: myMap.keySet()){
        //     System.out.println("Key -> "+key);
        //     System.out.println("Value -> "+myMap.get(key));
        // }

        // college class code for hashMap
        // HashMap<Integer, Integer> collegeRankingMap=new HashMap<>();
        MyHashMap<Integer, Integer> collegeRankingMap=new MyHashMap<>();
        collegeRankingMap.put(111,1);
        collegeRankingMap.put(312,2);
        collegeRankingMap.put(457,3);

        System.out.println(collegeRankingMap.get(111));

        System.out.println(collegeRankingMap.containsValue(1));

        // HashMap<MyCollege, MyRanking> collegeRankingMap2=new HashMap<>();
        MyHashMap<MyCollege, MyRanking> collegeRankingMap2=new MyHashMap<>();
        collegeRankingMap2.put(new MyCollege(111),new MyRanking(1));
        collegeRankingMap2.put(new MyCollege(312),new MyRanking(2));
        collegeRankingMap2.put(new MyCollege(457),new MyRanking(3));

        System.out.println(collegeRankingMap2.get(new MyCollege(111)));

        System.out.println(collegeRankingMap2.containsValue(new MyRanking(1)));
    }
}
