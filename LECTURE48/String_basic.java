package JAVA.SHASHCODE.LECTURE48;

// STRING => SEQUENCE OF CHARACTER => "shankar","","a"
// CHARACTER => 'a'
// println("_____")=> it also contain in blank space
// String is a class
public class String_basic {
    public static void main(String[] args) {
        String name="shankar";
        System.out.println(name);
        // call by refrences
        int arr[]=new int[3];
        int brr[]=arr;
        // arr[] and brr[] is in same shared memeory are the element will be same always if an change on arr it will reflect on arr[]=brr[]
        arr[0]=4;
        System.out.print(arr[0]); // 4
        brr[0]=8;
        System.out.print(arr[0]);// 8
        System.out.print(brr[0]);// 8

        // Now in String
        String name1="skj";
        System.out.println(name1); //skj
        String name2=name1;

        name2="E3";
        System.out.println(name1); //skj
        System.out.println(name2); // E3
        String name3="PuluPulu";
        System.out.println(name1); // skj
        System.out.println(name2); // E3
        System.out.println(name3); // PuluPulu
        
        // SCP => (String Constant Pull) => heap memory => unique data is arrange 
        String name4="abhinav";
        String name5="abhinav";
        String name6="abhinav";
        String name7=name4;
        System.out.print(name4==name5); // true
        System.out.print(name6==name7); // true
        System.out.print(name7==name4); // true
        System.out.print(name5==name6); // true

        //  in interger it is not follow
        int arr5[]=new int[3];
        int arr6[]=new int[3];
        int arr7[]=new int[3];
        int arr8[]=arr5;
        System.out.print(arr5==arr6); // false
        System.out.print(arr6==arr7); // false
        System.out.print(arr7==arr8); // false
        System.out.print(arr8==arr5); // true


        // String is Immutability
        // if you change like 
        String a="Skj";
        a="SKJ";
        // 2 DIFFERENT elements (like names) stored
        // if no one refer the any element(like => Skj) it is removed by garbage collector

        // String Object creation and logic
        String name9=new String("Shankar");
        // storage flow :-
        // name9 => store in stack memory
        // Shankar => store in heap memory
        // due to new operator an another "Shankar" store name9 refer gto that and the another refer to the main heap memory store "Shankar"

        String name10=name9;
        // storage flow :-
        // name10 => store in stack memory
        // name10 refer to Shankar => which is in store in due to new operator an another "Shankar" store

        name10="E3";
        // storage flow :-
        // name10 => store in stack memory
        // E3 => store in heap memory because it is not same as name9 element (like "Shankar")

        String name11="abhinav";
        String name12="abhinav";
        String name13="abhinav";
        String name14=name11;
        System.out.print(name11==name12); // false
        System.out.print(name12==name13); // false
        System.out.print(name13==name14); // false
        System.out.print(name14==name11); // true

        // INTERVIEW QUESTION
        String abc=new String("abc");
        //  Q.) how many string are created?
        // Ans.) 1 or 2 according to context.
        // reason of 1 string created.) if abc already exist in SCP (ie. "abc" already in heap memory)=> THEN only 1 string is created (i.e.to created object of that String "abc")
        // reason of 2 string created.) if abc not exist in SCP > THEN 2 string is created one for heap and one object

        //           FUNCTIONS OF STRING
        // compare 2 STRING value not refrences
        String name15= "abhinav";
        String name16="abhinav";
        System.out.print(name16.equals(name15)); 
        
    }
}
