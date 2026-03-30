package JAVA.SHASHCODE.LECTURE203;

import java.util.*;

// Application of graph
// 1. => Finding the shortest path b/w sources & Destination.
// 2. => FaceBook's Mutual Friends

// Represent agraph in Memory:
// 1. Adjacency Matrix
// 2. Adjacency


public class Graph_representation_and_application {
    int adjMatrix[][];

    List<List<Integer>> adjList;

    // for weighted graph in list we need a Pair class
    class Pair{
        int node;
        int weight;
        Pair(int n,int w){
            node=n;
            weight=w;
        }

        // node, weight
        @Override
        public String toString(){
            return "(" +node + ")";
        }
    }

    List<List<Pair>> adjListWithWeight;

    Graph_representation_and_application(int nodes){
        adjMatrix=new int[nodes][nodes]; // 4 * 4 [0..]
        adjList=new ArrayList<>();
        adjListWithWeight = new ArrayList<>();
        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
            adjListWithWeight.add(new ArrayList<>());
        }
    }

    // -> [[0,2],[0,1],[2,0]]
    public void addEdgeInMatrix(int edges[][], boolean isDirected){
        for(int edge[]:edges ){
            int u=edge[0];
            int v=edge[1];

            // directed 
            if(isDirected){
                adjMatrix[u][v]=1;
            }

            // Undirected 
            else{
                adjMatrix[u][v]=1;
                adjMatrix[v][u]=1;
            }

        }
    }
    
    public void addWithWeightEdgeInMatrix(int edges[][], boolean isDirected){
        for(int edge[]:edges ){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            
            // directed 
            if(isDirected){
                adjMatrix[u][v]=w;
            }
            
            // Undirected 
            else{
                adjMatrix[u][v]=w;
                adjMatrix[v][u]=w;
            }
            
        }
    }
    
    public void addEdgeInList(int edges[][], boolean isDirected){
        for(int edge[]:edges ){
            int u=edge[0];
            int v=edge[1];

            // directed 
            if(isDirected){
                adjList.get(u).add(v);
            }

            // Undirected 
            else{
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

        }
    }

    public void addEdgeWithWeightInList(int edges[][], boolean isDirected){
        for(int edge[]:edges ){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];

            // directed 
            if(isDirected){
                Pair pair=new Pair(v,w);
                adjListWithWeight.get(u).add(pair);
            }
            
            // Undirected 
            else{
                Pair pair1=new Pair(v,w);
                Pair pair2=new Pair(u,w);
                adjListWithWeight.get(u).add(pair1);
                adjListWithWeight.get(v).add(pair2);
            }

        }
    }

    public void printMatrix(){
        for(int i=0;i<adjMatrix.length;i++){
            System.out.print("Row "+i+" -> ");
            for(int j=0;j<adjMatrix[i].length;j++){
                System.out.print(adjMatrix[i][j]+" , ");
            }
            System.out.println();
        }
    }

    // 0 -> [1,2]
    // 1 -> [0]
    // []

    public void printList(){
        for(int i=0;i<adjList.size();i++){
            System.out.print(i+" -> ");
            System.out.print("[");
            for(int j=0;j<adjList.get(i).size();j++){
                System.out.print(adjList.get(i).get(j));
                if(j!=adjList.get(i).size()-1){
                    System.out.print(" , ");

                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void printWeightedList(){
        for(int i=0;i<adjListWithWeight.size();i++){
            System.out.print(i+" -> ");
            System.out.print("[");
            for(int j=0;j<adjListWithWeight.get(i).size();j++){
                System.out.print(adjListWithWeight.get(i).get(j));
                if(j!=adjListWithWeight.get(i).size()-1){
                    System.out.print(" , ");

                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void findInDegreeUnDirectedGraph(int edges[][], int nodes){
        int degree[]=new int[nodes];
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            degree[u]++;
            degree[v]++;
        }

        // print 
        for(int i=0;i<nodes;i++){
            System.out.println("node -> "+ i +" degree -> "+ degree[i]);
        }
    }

    public void findInDegreeDirectedGraph(int edges[][], int nodes){
        int inDegree[]=new int[nodes];
        int outDegree[]=new int[nodes];
        for(int edge[]:edges){
            int from=edge[0];
            int to=edge[1];
            inDegree[to]++;
            outDegree[from]++;
        }

        // print 
        for(int i=0;i<nodes;i++){
            System.out.print("node -> "+ i +" in-Degree -> "+ inDegree[i]+" - ");
            System.out.print("node -> "+ i +"out-Degree -> "+outDegree[i]);
        }
    }

    public static void main(String args[]){
        // int edges[][] = {{0,2},{0,1,},{1,2}};
        // int nodes = 4;
        // System.out.println("Undirected Graph -> ");
        // Graph_representation_and_application graph = new Graph_representation_and_application(nodes);
        // graph.addEdgeInMatrix(edges, false);
        // graph.printMatrix();

        // System.out.println("Directed Graph -> ");
        // Graph_representation_and_application graph1=new Graph_representation_and_application(nodes);
        // graph1.addEdgeInMatrix(edges,true);
        // graph1.printMatrix();


        // // WITH WEIGHT
        // int edges[][]= {{0,2,2},{0,2,1},{1,3,2}};
        // int nodes=4;
        // System.out.println("Weighted Undirected Graph -> ");
        // Graph_representation_and_application graph = new Graph_representation_and_application(nodes);
        // graph.addWithWeightEdgeInMatrix(edges, false);
        // graph.printMatrix();

        // System.out.println("Weighted Directed Graph -> ");
        // Graph_representation_and_application graph1=new Graph_representation_and_application(nodes);
        // graph1.addWithWeightEdgeInMatrix(edges,true);
        // graph1.printMatrix();



        // // List without weight
        // int edges[][] = {{0,2},{0,1,},{1,2}};
        // int nodes = 4;
        // System.out.println("Undirected Graph -> ");
        // Graph_representation_and_application graph = new Graph_representation_and_application(nodes);
        // graph.addEdgeInList(edges, false);
        // graph.printList();

        // System.out.println("Directed Graph -> ");
        // Graph_representation_and_application graph1=new Graph_representation_and_application(nodes);
        // graph1.addEdgeInList(edges,true);
        // graph1.printList();


        // // List with weight
        // int edges[][] = {{0,2},{0,1,},{1,2}};
        // int nodes = 4;
        // System.out.println("Undirected Graph -> ");
        // Graph_representation_and_application graph = new Graph_representation_and_application(nodes);
        // graph.addEdgeWithWeightInList(edges, false);
        // graph.printWeightedList();

        // System.out.println("Directed Graph -> ");
        // Graph_representation_and_application graph1=new Graph_representation_and_application(nodes);
        // graph1.addEdgeWithWeightInList(edges,true);
        // graph1.printWeightedList();


        // How to find degree of a graph
        int edges[][]={{0,2},{0,1},{1,3}};
        
        // --- directed graph --- //
        // find indegree of nodes using edges
        
        // find outdegree of nodes using edges
        
        // --- Undirected graph --- //
        // find degree of nodes
        Graph_representation_and_application graph = new Graph_representation_and_application(4);
        System.out.println("UnDirected Graph : ");
        graph.findInDegreeUnDirectedGraph(edges,4);
        System.out.println("Directed Graph : ");
        graph.findInDegreeDirectedGraph(edges,4);




    }
}
