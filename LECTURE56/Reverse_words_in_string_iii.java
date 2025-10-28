package JAVA.SHASHCODE.LECTURE56;

public class Reverse_words_in_string_iii {
    public static void main(String[] args) {
        
    }
    public String reverseWords(String s) {
        // convert to char array
        char arr[]=s.toCharArray();
        int len=arr.length;
        int startPointer=0;
        for(int EndPointer=0;EndPointer<=len;EndPointer++){

            // word will end at space or at end of string 
            if(EndPointer==len || arr[EndPointer]==' '){
                reverse(arr,startPointer,EndPointer-1);

                // first char of next word.
                startPointer=EndPointer+1;
            }
        }
        return new String(arr);
    }

    public static void reverse(char arr[],int startPointer,int EndPointer) {
        while(startPointer<EndPointer){
            char temp=arr[startPointer];
            arr[startPointer]=arr[EndPointer];
            arr[EndPointer]=temp;
            startPointer++;
            EndPointer--;
        }  
    }
}
