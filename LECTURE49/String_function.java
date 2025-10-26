package JAVA.SHASHCODE.LECTURE49;
import java.util.*;

public class String_function {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the line : ");
        String line=sc.nextLine();
        System.out.println(line);
        System.out.println("Enter the word : ");
        String word=sc.next();
        System.out.println(word);

        // function in string
        String str="Shankar";
        System.out.println(str.toLowerCase()); // shankar
        System.out.println(str); // Shankar
        str=str.toLowerCase();
        System.out.println(str.toLowerCase()); // shankar
        System.out.println(str); // shankar
        System.out.println(str.toUpperCase()); // SHANKAR
        System.out.println(str); // shankar

        System.out.println(str.charAt(0)); // s
        System.out.println(str.lastIndexOf('k')); // 4
        System.out.println(str.length());

        char ch[]=str.toCharArray();
        for(int i=0;i<ch.length;i++){
            System.out.println(ch[i]+" ");
        }

        // compare 2 string
        System.out.println("shankar".compareTo("shank")); // 2
        System.out.println("shank".compareTo("shankar")); // -2
        System.out.println("shankar".compareTo("shankar")); // 0 
        System.out.println("shankar".compareTo("E3")); // 22

        // TRIM (TO REMOVE EXTRA SPACES)
        System.out.println("        shankar             "); //          shankar
        System.out.println("        shankar             ".trim()); // shankar

        // startsWith (to check the starting string)
        System.out.println("shankar kumar E3".startsWith("shankar")); // true
        System.out.println("shankar kumar E3".startsWith("E3")); // false

        // endsWith (to check the ending string)
        System.out.println("shankar kumar E3".endsWith("E3")); // true
        System.out.println("shankar kumar E3".endsWith("shankar")); // false

        // substring creation 
        // substring of string "abc" => a,b,c,ab,bc,abc
        System.out.println("shankar kumar E3".substring(3)); // nkar kumar E3
        System.out.println("shankar kumar E3".substring(3,5)); // nk

        String mylocation="hyderabad, chennai, bangalore, noide, pune";
        String mylocationArray[]=mylocation.split(",");
        for(int i=0;i<mylocationArray.length;i++){
            System.out.print(mylocationArray[i]+" ");
        }

        String email1="Shahwattiwari8@gmil.com";
        String email2="randomAvenger@hotmail.com";

        String email1Arr[]=email1.split("@");
        String lastPart1=email1Arr[email1Arr.length-1];
        int dotIndex1=lastPart1.lastIndexOf('.');
        System.out.println(lastPart1.substring(0,dotIndex1));

        String email2Arr[]=email2.split("@");
        String lastPart2=email2Arr[email2Arr.length-1];
        int dotIndex2=lastPart2.lastIndexOf('.');
        System.out.println(lastPart2.substring(0,dotIndex2));

        // STRING => IMMUTABLE
        // MUTABLE 
        // => 1. STRING BUILDER (NON SYNCRONIZED) (NOT SAFE)
        // => 2. STRING BUFFER (SYNCRONIZED) (SAFE)

        StringBuilder name21=new StringBuilder("shankar");
        StringBuilder name22=new StringBuilder("shankar");
        StringBuilder name23=new StringBuilder("shankar");
        StringBuilder name24=name21;
        System.out.print(name21.equals(name22)); // false
        System.out.print(name22.equals(name23)); // false
        System.out.print(name23.equals(name24)); // false
        System.out.print(name24.equals(name21)); // true

        System.out.print(name21==name22); // false
        System.out.print(name22==name23); // false
        System.out.print(name23==name24); // false
        System.out.print(name24==name21); // true
        
        
        name24.append("kumar");
        System.out.print(name21.equals(name22)); // false
        System.out.print(name22.equals(name23)); // false
        System.out.print(name23.equals(name24)); // false
        System.out.print(name24.equals(name21)); // true

        System.out.print(name21==name22); // false
        System.out.print(name22==name23); // false
        System.out.print(name23==name24); // false
        System.out.print(name24==name21); // true

        sc.close();
    }
}

