package JAVA.SHASHCODE.LECTURE192;

import java.util.*;

class Student {
    int rollNo;
    int marks;
    String name;

    Student(int rollNo, int marks, String name) {
        this.rollNo = rollNo;
        this.marks = marks;
        this.name = name;
    }

    public String toString() {
        return rollNo + " " + marks + " " + name;
    }
}

public class Comperator {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student(3, 90, "Aman"));
        list.add(new Student(1, 95, "Riya"));
        list.add(new Student(2, 90, "Zoya"));
        list.add(new Student(2, 90, "Ankit"));

        // 🔹 Custom Comparator (same logic as your compareTo)
        Comparator<Student> customSort = (a, b) -> {
            if (b.marks != a.marks) {
                return b.marks - a.marks; // marks DESC
            }
            if (a.rollNo != b.rollNo) {
                return a.rollNo - b.rollNo; // roll ASC
            }
            return a.name.compareTo(b.name); // name ASC
        };

        Collections.sort(list, customSort);

        System.out.println("Custom Sorted:");
        for (Student s : list) {
            System.out.println(s);
        }

        // 🔹 Another Comparator (sort by name only)
        Comparator<Student> nameSort = (a, b) -> a.name.compareTo(b.name);

        Collections.sort(list, nameSort);

        System.out.println("\nSorted by Name:");
        for (Student s : list) {
            System.out.println(s);
        }

        // 🔹 Another Comparator (marks ascending)
        Comparator<Student> marksAsc = (a, b) -> a.marks - b.marks;

        Collections.sort(list, marksAsc);

        System.out.println("\nSorted by Marks Asc:");
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
