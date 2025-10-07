            // LECTURE 14 & 15 PLAYT WITH BITS

// package JAVA.SHASHCODE.LECTURE13;

public class Bits {
    public static void main(String[] args) {
        printBits(32);
        printOddEven(45);
        int res=setIthBit(32,1);
        printBits(res);
        int res1=toggleIthBit(32,5);
        printBits(res1);
        int res2=unSetIthBit(32,5);
        printBits(res2);
        isPowerOf2(32);
        int res3=unSetRightMostSetBit(40);
        printBits(res3);
        NoofSetBit(15);
        int res4=clearLSB(15,2);
        printBits(res4);
        int res5=clearMSB(15,2);
        printBits(res5);
        int res6=clearMSBExclusive(15,2);
        printBits(res6);
        char ch=toUpperCase('b');
        System.out.println(ch); 
        char chU=toUpperCaseUnderScore('b');
        System.out.println(chU);
        char ch1=toLowerCase('B');
        System.out.println(ch1);
        char ch2=toLowerCaseUsingSpace('B');
        System.out.println(ch2);
        swap(5,6);
        int arr[]={2,3,5,6,3,2,5};
        uniqueElement(arr); 
        twoUniqueElement(new int[]{2,3,5,6,3,2,5,7});

    }
    public static void printBits(int num){
        for(int i=7;i>=0;i--){
            System.out.print((num>>i)& 1);
        }
        System.out.println();
    }

    // print odd even
    public static void printOddEven(int num){
        if (isBitSet(num, 0)){
            System.out.println("Number is odd");
        }
        else{
            System.out.println("Number is even");
        }
    }

    // print if ith bit is set or not
    public static boolean isBitSet(int num,int bit){
        int res=num & (1<<bit);
        return(res==0)?false:true;
    }

    // set ith bit => OR
    public static int setIthBit(int num,int bit){
        return num | (1<<bit);
    }

    // Toggle the ith bit => XOR ,<< LEFT SHIFT
    public static int toggleIthBit(int num,int bit){
        return num ^ (1<<bit);
    }

    // Unset the ith bit => AND with NOT ,<< LEFT SHIFT
    public static int unSetIthBit(int num,int bit){
        return num & (~(1<<bit));
    }
    
    // power of 2
    public static void isPowerOf2(int num){  
        if((num & (num-1))==0){
            System.out.println("Number is power of 2");
        } 
        else{
            System.out.println("Number is not power of 2");
        }
    }

    // unSetRightMostSETBit RIGHT MOST SET BIT
    public static int unSetRightMostSetBit(int num){
        return num & (num-1);
    }
    // No of set bit
    public static void NoofSetBit(int num){
        int count=0;
        while(num!=0){
            count++;
            num=unSetRightMostSetBit(num);
        }
        System.out.println("No of set bits are: "+count);
    }

    //  clear LSB from ith position
    public static int clearLSB(int num,int bit){
        return num & (~((1<<bit)-1));
    }

    // clear MSB from ith position
    public static int clearMSB(int num,int bit){
        return num & ((1<<bit)-1);
    }

    // clear MSB from ith position
    public static int clearMSBExclusive(int num,int bit){
        return num & ((1<<bit+1)-1);
    }
    
    //  convert Char to UpperCase
    public static char toUpperCase(int num){
        return (char)(num & ~(1<<5));
    }
    //  convert Char to UpperCase using underscore
    // 32 ASCII value of underscore and '_' = 0101 1111

    public static char toUpperCaseUnderScore(int num){
        return (char)(num & '_');
    }

    //  convert Char to LowerCase
    public static char toLowerCase(int num){
        return (char)(num | (1<<5));
    }

    // convert Char to LowerCase using space
    // 32 ASCII value of space and ' ' = 0010 0000
    public static char toLowerCaseUsingSpace(int num){
        return (char)(num | ' ');
    }

    // Swaping 2 number using XOR
    public static void swap(int a,int b){
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("a: "+a+" b: "+b);
    }

    // Array in the elements come twice except one element which comes once
    public static void uniqueElement(int arr[]){
        int unique=0;
        for(int i=0;i<arr.length;i++){
            unique=unique^arr[i];
        }
        System.out.println("Unique element is: "+unique);
    }

    // Print 2 unique elements in an array
    public static void twoUniqueElement(int arr[]){
        int l=arr.length;
        int res=0;
        for(int i=0;i<l;i++){
            res=res^arr[i];
        }
        int setBit=0;
        int bit=0;
        while(res!=0){
            if((res & 1)==1){
                setBit=bit;
                break;
            }
            bit++;
        }
        int res1=0;
        for(int i=0;i<l;i++){
            if((arr[i] & (1<<setBit))!=0){
                res1=res1^arr[i];
            }
        }
        int num1=res^ res1;
        int num2=num1^res;
        System.out.println("Two unique elements are: "+num1+" and "+num2);
    }

}
