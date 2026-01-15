package JAVA.SHASHCODE.LECTURE154;

import java.util.ArrayList;
// import java.util.Collections;

// TC => 4 ^ (N^2) (WORST CASE)

public class Rat_in_maze_problem {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> res=new ArrayList<>();
        backtrack(0,0,maze,new StringBuilder(""),res);
        // Collections.sort(res);
        return res;
    }
    private void backtrack(int r,int c, int[][] maze,StringBuilder cur,ArrayList<String> res){
        int n=maze.length;

        // base case
        if(r>=n || c>=n || r<0 ||c<0){
            return;
        }
        // if already visited 
        if(maze[r][c] == 2){
            return ;
        }
        // if path is blocked
        if(maze[r][c] ==0){
            return;
        }

        // destination
        if(r==n-1 && c==n-1){
            res.add(cur.toString());
            return;
        }
        maze[r][c]=2;
        
        // down
        cur.append("D");
        backtrack(r+1, c, maze, cur, res);
        cur.deleteCharAt(cur.length()-1);
        
        // left
        cur.append("L");
        backtrack(r, c-1, maze, cur, res);
        cur.deleteCharAt(cur.length()-1);
        
        // right
        cur.append("R");
        backtrack(r, c+1, maze, cur, res);
        cur.deleteCharAt(cur.length()-1);
        
        // up
        cur.append("U");
        backtrack(r-1, c, maze, cur, res);
        cur.deleteCharAt(cur.length()-1);

        maze[r][c]=1; // backtrack
    }
}
