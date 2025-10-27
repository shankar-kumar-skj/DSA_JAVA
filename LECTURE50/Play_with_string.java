import java.util.Scanner;

public class Play_with_string {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the word ");
        String word1=sc.next();
        System.out.println("Enter the word please");
        String word2=sc.next();
        
        System.out.println("Enter the line ");
        String line1=sc.nextLine();
        System.out.println("Enter next line");
        String line2=sc.nextLine();

        System.out.println("word1 : "+word1+",");
        System.out.println("word2 : "+word2+",");
        System.out.println("line1 : "+line1+"*");
        System.out.println("line2 : "+line2+"*");

        // concatination in STRING 

        // INTERGER + INTERGER + STRING = INTEGER + STRING
        System.out.println(23+332+"SHANKAR");

        // INTERGER + FLOAT + STRING = FLOAT + STRING
        System.out.println(23+332+"SHANKAR");

        // STRING + INTERGER + INTERGER = STRING + STRING(INTEGER) + STRING(INTEGER)
        System.out.println("SHANKAR"+23+332);

        // STRING + INTERGER + FLOAT = STRING + STRING(INTEGER) + STRING(FLOAT)
        System.out.println("SHANKAR"+23+33.2);

        // STRING FORMATTING :-

        double num=45.66665456;
        System.out.println(num);

        // round of decimal number
        System.out.printf("number is %.2f",num);
        String address="India";
        String name=String.format("NUMBER IS %.2f address is %s",num,address);
        String name1=String.format("NUMBER IS %2$f address is %1$s",address,num);
        System.out.println(name);
        System.out.println(name1);
        
        sc.close();
    }
}
