package JAVA.SHASHCODE.LECTURE215;

// Multiple scorce point BFS
// => Multiple scorce => all four direction move in 1 time period
// BFS => MINIMUM Time finding


// 0 => empty cell
// 1 => fresh oranges
// 2 => rotten oranges

import java.util.*;

public class Rotting_oranges_bfs_graph {
    // public int orangesRotting(int[][] grid) {
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     int freshCount=0;
    //     Queue<int []> queue=new LinkedList<>();
    // //    O(m*n)
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(grid[i][j]==1){
    //                 freshCount++;
    //             }
    //             else if(grid[i][j]==2){
    //                 queue.offer(new int[] {i,j});
    //             }
    //         }
    //     }
    //     if(freshCount==0){
    //         return 0;
    //     }
    // //    O(m*n)
    //     int time=0;
    //     while(!queue.isEmpty()){
    //         int size=queue.size();
    //         for(int i=0;i<size;i++){
    //             int rottenLoc[]=queue.poll();
    //             int r=rottenLoc[0];
    //             int c=rottenLoc[1];
    //             int neighbours[][]={
    //                 {r-1,c},{r,c+1},{r+1,c},{r,c-1}
    //             };
    //             for(int neighbour[] : neighbours){
    //                 int nr=neighbour[0];
    //                 int nc=neighbour[1];
    //                 // out bound / Visisted / rotted
    //                 if(nr<0 || nr>=n || nc<0 || nc>=m || grid[nr][nc]==2 || grid[nr][nc] == 0){
    //                     continue;
    //                 }
    //                 queue.offer(new int[]{nr,nc});
    //                 grid[nr][nc] = 2; // visited
    //             }
    //         }
    //         time++;
    //         freshCount-=queue.size();
    //         if(freshCount==0){
    //             break;
    //         }
    //     }
    //     return (freshCount==0)?time:-1;
    // }

    // Method 2
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int freshCount=0;
        Queue<int []> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    freshCount++;
                }
                else if(grid[i][j]==2){
                    queue.offer(new int[] {i,j});
                }
            }
        }
        if(freshCount==0){
            return 0;
        }
        int time=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int rottenLoc[]=queue.poll();
                int r=rottenLoc[0];
                int c=rottenLoc[1];
                int neighbours[][]={
                    {r-1,c},{r,c+1},{r+1,c},{r,c-1}
                };
                for(int neighbour[] : neighbours){
                    int nr=neighbour[0];
                    int nc=neighbour[1];
                    // out bound / Visisted / rotted
                    if(nr<0 || nr>=n || nc<0 || nc>=m || grid[nr][nc]==2 || grid[nr][nc] == 0){
                        continue;
                    }
                    queue.offer(new int[]{nr,nc});
                    grid[nr][nc] = 2; // visited
                    freshCount--;
                    if(freshCount==0){
                        return time+1;
                    }
                }
            }
            time++;
        }
        return (freshCount==0)?time:-1;
    }
}
