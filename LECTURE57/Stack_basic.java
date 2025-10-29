package JAVA.SHASHCODE.LECTURE57;
import java.util.*;
// array implementation

public class Stack_basic {
    int stack[];
    int top;
    int size;
    public Stack_basic(int stackSize){
        stack= new int[stackSize];
        size=stackSize;
        top=-1;
    }

    // insert
    public void push(int element){
        if(top>=size-1){
            System.out.println("STACK IS FULL! - OVERFLOW CONDITION!!");
            return;
        }
        top++;
        stack[top]=element;
    }

    // isEmpty 
    public boolean isEmpty(){
        return top<=-1;
    }

    // size
    public int size(){
        return top+1;
    }

    // top element - peek
    public int peek(){
        if(isEmpty()){
            System.out.println("STACK IS EMPTY! - UNDERFLOW CONDITION!!");
            return Integer.MIN_VALUE;
        }
        return stack[top];
    }


    // pop - delete  of the top element
    public int pop(){
        int val=peek();
        if(val!=Integer.MIN_VALUE){
            top--;
        }
        return val;
    }

    // print stack
    public void printStack(){
        System.out.println("Printing stack : ");
        for(int i=0;i<=top;i++){
            System.out.print(stack[i]);
            if(i!=top){
               System.out.println(","); 
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Stack_basic stack=new Stack_basic(n);
        System.out.println("isEmpty: "+ stack.isEmpty());
        stack.push(9);
        stack.printStack();
        stack.push(1);
        stack.printStack();
        stack.push(8);
        stack.printStack();
        stack.push(5);
        stack.printStack();
        stack.push(8);
        stack.printStack();
        stack.push(2);
        stack.printStack();
        stack.push(6);
        stack.printStack();
        stack.pop();
        stack.printStack();
        System.out.println("SIZE : "+ stack.size());
        System.out.println("isEmpty: "+ stack.isEmpty());
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        System.out.println("peak : "+stack.peek());
        sc.close();

        // java collection stack implementation
        Stack<Integer> Stack_basic=new Stack<>();
        Stack_basic.peek();
        Stack_basic.push(2);
        Stack_basic.pop();
        Stack_basic.size();
        Stack_basic.isEmpty();
    }
}
