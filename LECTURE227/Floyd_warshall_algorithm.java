package JAVA.SHASHCODE.LECTURE227;

// TC => O(N^3)

// Floyd Warshall Alogrithm :-
// 1. distance from each city from every city shortest Path
// 2. to try all possibility

// dist[i][j]=Math.min(dist[i][j], dist[i][via]+ dist[via][j]);

// When to use:
// => To find shortest from every node to every other node.
// => Multi-Source path algorithm.
// => It can detect negative cycle
// Easiest to creat & understand
// Uses Dynamic Programming

public class Floyd_warshall_algorithm {
    public void shortest_distance(int[][] matrix){
        // code here
        // matrix[i][j]== -1 no path to infinity
        int n= matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=1001;
                }
            }
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    // floyd warshal
                    matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }

        for(int i=0;i<n;i++){
            if(matrix[i][i]<0){
                System.out.print("Negative Cycle");
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1001){
                    matrix[i][j]=-1;
                }
            }
        }
    }

    // for infinity gfg
    public void floydWarshall(int[][] matrix) {
        int n = matrix.length;
        int INF = (int)1e9;

        // Step 1: Convert 10^8 to INF
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 100000000){
                    matrix[i][j] = INF;
                }
            }
        }

        // Step 2: Floyd Warshall
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(matrix[i][k] < INF && matrix[k][j] < INF){
                        matrix[i][j] = Math.min(
                            matrix[i][j],
                            matrix[i][k] + matrix[k][j]
                        );
                    }
                }
            }
        }

        // Step 3: Convert INF back to 10^8
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == INF){
                    matrix[i][j] = 100000000;
                }
            }
        }
    }
}



