package JAVA.SHASHCODE.LECTURE86;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// class MyStudent{
//     int maxMarks;
//     int rollNumber;
//     MyStudent(int maxMarks, int rollNumber){
//         this.rollNumber =rollNumber;
//         this.maxMarks=maxMarks;
//     }
//     @Override
//     public String toString(){
//         String val="Marks : "+ this.maxMarks+" , "+ "Roll Number" + this.rollNumber;
//         return val;
//     }
// }

// public class Compare_object {
//     public static void main(String[] args) {
//         // ArrayList<Integer> arr=new ArrayList<>();
//         // // sort on the basis of unit digit and 
//         // // if unit digit is same then print the smaller number first
//         // arr.add(10);
//         // arr.add(20);
//         // arr.add(14);
//         // arr.add(53);
//         // arr.add(45);

//         ArrayList<MyStudent> arr=new ArrayList<>();
//         // sort on the basis of unit digit and 
//         // if unit digit is same then print the smaller number first
//         arr.add(new MyStudent(90,20));
//         arr.add(new MyStudent(90,10));
//         arr.add(new MyStudent(88,22));
//         arr.add(new MyStudent(88,24));
//         arr.add(new MyStudent(96,2));
//         arr.add(new MyStudent(64,1));

//         Compare_object c1=new Compare_object();
//         Comparator<MyStudent> cmp=new Comparator<MyStudent>() {
//             public int compare(MyStudent o1,MyStudent o2){
//                 // If 1 then swap +ve
//                 // If 0 or -1 then don't swap -ve
//                 int mark1=o1.maxMarks;
//                 int mark2=o2.maxMarks;
//                 if(mark1==mark2){
//                     return o1.rollNumber-o2.rollNumber;
//                 }
//                 return o2.maxMarks-o1.maxMarks;
//                 // if(u1<u2){
//                 //     return -1; // 
//                 // }
//                 // else if(u1>u2){
//                 //     return 1;
//                 // }
//                 // else{
//                 //     if(u1<u2){
//                 //         return -1;
//                 //     }
//                 //     else if(u1>u2){
//                 //         return 1;
//                 //     }
//                 // }
//                 // return 0;
//             }
//         };

//         Collections.sort(arr,cmp);
//         c1.display(arr);

//     }
//     public <T> void display (ArrayList<T> list){
//         for(int i=0;i<list.size();i++){
//             System.out.println(list.get(i)+",");
//             // if(i!=list.size()-1){
//             //     System.out.print(",");
//             // }
//         }
//         System.out.println();
//     }
// }

class MyStudent implements Comparable<Student>{
    int maxMarks;
    int rollNumber;

    MyStudent(int maxMarks, int rollNumber){
        this.rollNumber =rollNumber;
        this.maxMarks=maxMarks;
    }

    public String toString(){
        String val="Marks : "+ this.maxMarks+" , "+ "Roll Number" + this.rollNumber;
        return val;
    }

    public int compareTo(MyStudent that){
        // o1 -> this
        //     o2 -> that
        // If 1 then swap +ve
        // If 0 or -1 then don't swap -ve
        int mark1=this.maxMarks;
        int mark2=that.maxMarks;
        if(mark1==mark2){
            return this.rollNumber-that.rollNumber;
        }
        return that.maxMarks-this.maxMarks;

    }
}

public class Compare_object {
    public static void main(String[] args) {
        // ArrayList<Integer> arr=new ArrayList<>();
        // // sort on the basis of unit digit and 
        // // if unit digit is same then print the smaller number first
        // arr.add(10);
        // arr.add(20);
        // arr.add(14);
        // arr.add(53);
        // arr.add(45);

        ArrayList<MyStudent> arr=new ArrayList<>();
        // sort on the basis of unit digit and 
        // if unit digit is same then print the smaller number first
        arr.add(new MyStudent(90,20));
        arr.add(new MyStudent(90,10));
        arr.add(new MyStudent(88,22));
        arr.add(new MyStudent(88,24));
        arr.add(new MyStudent(96,2));
        arr.add(new MyStudent(64,1));

        Compare_object c1=new Compare_object();
        Comparator<MyStudent> cmp=new Comparator<MyStudent>() {
            public int compare(MyStudent o1,MyStudent o2){
                // If 1 then swap +ve
                // If 0 or -1 then don't swap -ve
                int mark1=o1.maxMarks;
                int mark2=o2.maxMarks;
                if(mark1==mark2){
                    return o1.rollNumber-o2.rollNumber;
                }
                return o2.maxMarks-o1.maxMarks;
                // if(u1<u2){
                //     return -1; // 
                // }
                // else if(u1>u2){
                //     return 1;
                // }
                // else{
                //     if(u1<u2){
                //         return -1;
                //     }
                //     else if(u1>u2){
                //         return 1;
                //     }
                // }
                // return 0;
            }
        };

        Collections.sort(arr);
        c1.display(arr);

    }
    public <T> void display (ArrayList<T> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i)+",");
            // if(i!=list.size()-1){
            //     System.out.print(",");
            // }
        }
        System.out.println();
    }
}
