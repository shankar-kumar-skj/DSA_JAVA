package JAVA.SHASHCODE.LECTURE150;

public class Recursion_on_array {

}

class PrintStringDemo {
    private void printChars(int index, String str) {
        // base case
        if (index == str.length()) {
            return;
        }
        System.out.println(str.charAt(index) + " ");
        printChars(index + 1, str);
    }

    private void printReverseChars(int index, String str) {
        // base case
        if (index == str.length()) {
            return;
        }
        printChars(index + 1, str);
        System.out.println(str.charAt(index) + " ");
    }

    public static void main(String[] args) {
        String str = "SHASHCODE";
        PrintStringDemo pd = new PrintStringDemo();
        pd.printChars(0, str);
        pd.printReverseChars(0, str);
    }
}

class PalindromeStringDemo {
    private boolean checkPalindrome(String str, int i, int j) {
        // base case
        if (i >= j) {
            return true;
        }
        if (str.charAt(i) != str.charAt(j))
            return false;
        return checkPalindrome(str, i + 1, j - 1);
    }

    public static void main(String[] args) {
        String str = "NAMAN";
        PalindromeStringDemo pd = new PalindromeStringDemo();
        boolean res = pd.checkPalindrome(str, 0, str.length());
        System.out.println("Is " + str + " palindrome ? => " + res);
    }
}

// remove string chacter using recursion
class RemoveCharFromStringDemo {
    private String removeChars(String str, char ch, int index) {
        // base case
        if (index == str.length())
            return "";
        String prev = removeChars(str, ch, index + 1);
        if (ch == str.charAt(index)) {
            return prev;
        }
        return (str.charAt(index) + prev);
    }

    public static void main(String[] args) {
        String str = "SHASHCODE";
        char ch = 'A';
        RemoveCharFromStringDemo pd = new RemoveCharFromStringDemo();
        String res = pd.removeChars(str, ch, 0);
        System.out.println("Updated string after removing all " + ch + " is => " + res);
    }
}

// Replace PI with 3.14
class ReplacePiInString {
    private String replacePI(String str, int index) {
        // base case
        int n = str.length();
        if (index == n)
            return "";
        if (index > n - 1 && str.charAt(index) == 'P' && str.charAt(index + 1) == 'I') {
            return ("3.14" + replacePI(str, index + 2));
        } else {
            return (str.charAt(index) + replacePI(str, index + 1));
        }
    }

    public static void main(String[] args) {
        String str = "XPIPIX";
        ReplacePiInString pd = new ReplacePiInString();
        String res = pd.replacePI(str, 0);
        System.out.println("Updated string after replacing all PI is => " + res);
    }
}

class Solution {
    public String countAndSay(int n) {
        // base case
        if (n == 1)
            return "1";
        String prev = countAndSay(n - 1);
        StringBuilder res = new StringBuilder("");
        int count = 0;
        int len = prev.length();
        for (int i = 0; i < len; i++) {
            count++;
            if (i == len - 1 || prev.charAt(i) != prev.charAt(i + 1)) {
                res.append(count).append(prev.charAt(i));
                count = 0;
            }
        }
        return res.toString();
    }
}
