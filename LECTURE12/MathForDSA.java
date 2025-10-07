package JAVA.SHASHCODE.LECTURE12;
import java.util.Scanner;

public class MathForDSA {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        decimalToBinary(5);
        decimalToAnyBase(5,2);
        binaryToDecimal(10001);
        AnyBaseToDecimal(10001,10);
        int number=sc.nextInt();
        Checkeven(number);
        ReverseNumber(number);
        power(23,2);
        fastExponentiation(23,2);
        sc.close();
    }
    static void decimalToBinary(int decimalNum){
        int resNum=0;
        int power=0;
        while(decimalNum>0){
            int rem=decimalNum%2;
            decimalNum/=2;
            resNum+= rem*Math.pow(10,power);
            power++;

        }
        System.out.println("Result is : "+resNum);
    }
    static void decimalToAnyBase(int decimalNum,int base){
        int resNum=0;
        int power=0;
        while(decimalNum>0){
            int rem=decimalNum%base;
            decimalNum/=base;
            resNum+= rem*Math.pow(10,power);
            power++;

        }
        System.out.println("Result is : "+resNum);
    }
    static void binaryToDecimal(int binaryNum){
        int resNum=0;
        int power=0;
        while(binaryNum>0){
            int unitDigit=binaryNum%10;
            binaryNum/=10;
            resNum+= unitDigit*Math.pow(2,power);
            power++;

        }
        System.out.println("Result is : "+resNum);
    }
    static void AnyBaseToDecimal(int binaryNum,int base){
        int resNum=0;
        int power=0;
        while(binaryNum>0){
            int unitDigit=binaryNum%base;
            binaryNum/=base;
            resNum+= unitDigit*Math.pow(2,power);
            power++;

        }
        System.out.println("Result is : "+resNum);
    }
    // even or odd code
    static void Checkeven(int number){
        if(number%2==0){
            System.out.println("even");
        }
        else{
            System.out.println("odd");
        }
    }
    // number reversing
    static void ReverseNumber(int number){
        int revNum=0;
        while(number>0){
            int digit=number%10;
            revNum=revNum*10+digit;
            number/=10;
        }
        System.out.println("Reverse is: "+revNum);
    }
    // power finder user code of math.pow
    static double power(int num,int power)
    {
        double res=1;
        for(int i=0;i<power;i++){
        res=res*num;
    }
    return res;
    }
    static double fastExponentiation(int num,int power)
    {
        double res=1;
        while (power>0) {
            if(power%2!=0){
                res=res*num;
                power=(power-1)/2;
            }
            // else{
        //         power/=2;
        // }
        power/=2;        
        num=num*num;   
        }
        System.out.println(res);
    return res;
    }

}
