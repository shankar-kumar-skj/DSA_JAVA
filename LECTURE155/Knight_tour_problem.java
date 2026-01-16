package JAVA.SHASHCODE.LECTURE155;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Knight_tour_problem {
    // public ArrayList<ArrayList<Integer>> knightTour(int n) {
    //     // code here
        
    // }
    public static void main(String[] args){
        System.out.println("Knight Tour Problem");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sol[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(sol[i],-1);
        }

        sol[0][0]=0;
        if(solve(0,0,sol,n,1)==true){
            printSol(sol);
        }
        else{
            System.out.println("Solution does not exist");
        }
        sc.close();
    }

    public static boolean isSafe(int sol[][],int i,int j,int N){
        if(i<0 || i>=N || j<0 || j>=N || sol[i][j]!=-1){
            return false;
        }
        return true;
    }

    public static boolean solve(int i,int j, int sol[][],int N,int moves){
        // bese case
        if(moves == N * N){
            return true;
        }

        int dx[]={2,1,-1,-2,-2,-1,1,2};
        int dy[]={1,2,2,1,-1,-2,-2,-1};

        for(int k=0;k<8;k++){
            int nextI = i+dx[k];
            int nextJ = j+dy[k];
            if(isSafe(sol,nextI,nextJ,N)){
                sol[nextI][nextJ]=moves;
                if(solve(nextI,nextJ,sol,N,moves+1)==true){
                    return true;
                }
                else{
                    sol[nextI][nextJ]=-1;
                }
            }
        }
        return false;
    }

    public static void printSol(int sol[][]){
        for(int i=0;i<sol.length;i++){
            for(int j=0;j<sol[i].length;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
}
