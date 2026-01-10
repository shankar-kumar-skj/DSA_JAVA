package JAVA.SHASHCODE.LECTURE151;

// order matters
// elements can be skipped
// "n" size array total subsequences in (2^n)
// TC => N(2^N)

public class Recursion_subsequence_pattern {
    private void printSubSequences(String input, int index, String current){
        // base case
        if(index==input.length()){
            System.out.print(current+ " ,");
            return;
        }

        // pick
        printSubSequences(input, index+1, current+input.charAt(index));
        // Not pick
        printSubSequences(input, index+1, current);
    }

    // Print selected subsequence 
    
    private void printSelectedSubSequencesWithA(String input, int index, String current){
        // base case
        if(index==input.length()){
            if(current.startsWith("a")){
                System.out.print(current+ " ,");
            }
            return;
        }

        // pick
        printSelectedSubSequencesWithA(input, index+1, current+input.charAt(index));
        // Not pick
        printSelectedSubSequencesWithA(input, index+1, current);
    }

    public static void main(String[] args){
        String input="abc";
        Recursion_subsequence_pattern pd1=new Recursion_subsequence_pattern();
        pd1.printSubSequences(input, 0, "");
        pd1.printSelectedSubSequencesWithA(input, 0, "");
    }
}

class CountSubsequence{
    private int countSubsequences(String input,int index,String current){
        // base case 
        if(index==input.length()){
            return 1;
        }
        // ab
        // pick case
        int pick=countSubsequences(input,index+1,current+input.charAt(index));

        // ab
        // no pick case
        int noPick=countSubsequences(input, index+1, current);

        return pick + noPick;
    }
    private int countSubsequencesStartingwithA(String input,int index,String current){
        // base case 
        if(index==input.length()){
            if(current.startsWith("a")){
                return 1;
            }
            return 0;
        }
        // ab
        // pick case
        int pick=countSubsequences(input,index+1,current+input.charAt(index));

        // ab
        // no pick case
        int noPick=countSubsequences(input, index+1, current);

        return pick + noPick;
    }
    public static void main(String[] args) {
        String input="abc";
        CountSubsequence pd2=new CountSubsequence();
        int res1=pd2.countSubsequences(input,0,"");
        System.out.println("Count is :"+res1);
        int res2=pd2.countSubsequencesStartingwithA(input,0,"");
        System.out.println("Count of subsequence starting with 'a' is :"+res2);
    }
}
