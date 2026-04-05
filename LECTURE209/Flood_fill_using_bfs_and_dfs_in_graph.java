package JAVA.SHASHCODE.LECTURE209;

import java.util.*;

// TC => O(rows*cols)
// SC => O()
public class Flood_fill_using_bfs_and_dfs_in_graph {

    // DFS Method 1:-
    // int rows;
    // int cols;
    // void dfs(int row, int col,int newColor,int curColor,boolean visited[][],int
    // image[][]){
    // // out of bound cases
    // if(row<0||row>=rows||col<0||col>=cols ){
    // return;
    // }
    // if(image[row][col]!=curColor){
    // return;
    // }
    // if(visited[row][col]){
    // return;
    // }

    // image[row][col]=newColor;
    // visited[row][col]=true;

    // // neighbour
    // int adjList[][]={
    // {row-1,col},{row,col+1},{row+1,col},{row,col-1}
    // };
    // for(int neighbour[]: adjList){
    // dfs(neighbour[0],neighbour[1],newColor,curColor,visited,image);
    // }
    // }
    // public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    // rows=image.length;
    // cols=image[0].length;
    // boolean[][] visited=new boolean[rows][cols];
    // dfs(sr,sc,color,image[sr][sc],visited,image);
    // return image;
    // }

    // // DFS Method 2 : visited removing method
    // int rows;
    // int cols;
    // void dfs(int row, int col,int newColor,int curColor,int image[][]){
    // // out of bound cases
    // if(row<0||row>=rows||col<0||col>=cols ){
    // return;
    // }
    // if(image[row][col]!=curColor){
    // return;
    // }
    // if(image[row][col]==newColor){
    // return;
    // }

    // image[row][col]=newColor;

    // // neighbour
    // int adjList[][]={
    // {row-1,col},{row,col+1},{row+1,col},{row,col-1}
    // };
    // for(int neighbour[]: adjList){
    // dfs(neighbour[0],neighbour[1],newColor,curColor,image);
    // }
    // }
    // public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    // rows=image.length;
    // cols=image[0].length;
    // dfs(sr,sc,color,image[sr][sc],image);
    // return image;
    // }

    // BFS Method 1 : QUEUE METHOD
    int rows;
    int cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        int curColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { sr, sc });
        image[sr][sc] = color; // fill/visit
        while (!queue.isEmpty()) {
            int node[] = queue.poll();
            int row = node[0];
            int col = node[1];
            // neighbour
            int adjList[][] = {
                    { row - 1, col }, { row, col + 1 }, { row + 1, col }, { row, col - 1 }
            };
            for (int neighbour[] : adjList) {
                int r=neighbour[0];
                int c=neighbour[1];
                // out of bound cases
                if (r < 0 || r >= rows || c < 0 || c >= cols) {
                    continue;
                }
                if (image[r][c] != curColor) {
                    continue;
                }
                if (image[r][c] == color) {
                    continue;
                }
                queue.offer(new int[]{r,c});
                image[r][c]=color;
            }
        }
        return image;
    }
}
