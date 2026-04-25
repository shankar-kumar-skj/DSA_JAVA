package JAVA.SHASHCODE.LECTURE232;

// Disjoint Set Union (DSU) => It is used to solve multiple components questions on graph
// ==> DSU's are mostly used in dynamic graph (config keep on changing)

// Ex : 
// Ques.) How many components are there in this graph
// Ques.) Is "one element" is rechable from "other element"
// Ques.) Does "one element" and "other element" is lies in same components.

// DSU
// 1. Find Parent() => find the root of a component.
// 2. Union() =>Connect 2 componenets
//   (i) Union by rank 
//   (ii) Union by Size

// Steps for Union By Rank union(u,v) :-
// => Find root parent of u & v (RPu,RPv)
// => Find rank of (RPu,RPv)
// => Connect smaller Rnak to larger Rank
// => if Rank is not same, don't increment
// => if Rank is same, increment Rank of u, given that v is attached u.

// Find Parent => With path comparession 
// 

public class DSU_disjoint_sets_in_one_shot {
    int parent[];
    int rank[];
    int size[];
    int components;
    DSU_disjoint_sets_in_one_shot(int nodes){
        this.parent = new int[nodes];
        this.rank = new int[nodes];
        this.size = new int[nodes];
        this.components=nodes;
        for(int i=0;i<nodes;i++){
            this.parent[i]=i;
            this.rank[i]=0;
            this.size[i]=1;
        }
    }

    public int findRootParent(int nodes){
        if(nodes==parent[nodes]){
            return nodes;
        }
        // Path Compression
        parent[nodes] =findRootParent(parent[nodes]);
        return parent[nodes];
    }

    public void unionByRank(int node1,int node2){
        // 1. find the root parent
        int rootParent1=findRootParent(node1);
        int rootParent2=findRootParent(node2);
        if(rootParent1==rootParent2){
            return;
        }
        components--;
        if(rank[rootParent1]<rank[rootParent2]){
            parent[rootParent1]=rootParent2;
        }
        else if(rank[rootParent1]>rank[rootParent2]){
            parent[rootParent2]=rootParent1;
        }
        else{
            parent[rootParent2]=rootParent1;
            rank[rootParent1]++;
        }
    }

    // Union By Size (u,v)
    // -> find root parent of u & v (RPu, RPv)
    // -> find size of (RPu,RPv)
    // -> Correct Smaller size component to larger size component & increase size of larger component by Smaller size Component
    // -> If size is same, attach any to any
    
    public void unionBySize(int node1, int node2){
        // 1. find the root parent
        int rootParent1=findRootParent(node1);
        int rootParent2=findRootParent(node2);
        if(rootParent1==rootParent2){
            return;
        }
        components--;

        // 2. Union of Components
        if(size[rootParent1]<size[rootParent2]){
            parent[rootParent1]=rootParent2;
            size[rootParent2] +=size[rootParent1];
        }
        else{
            parent[rootParent2]=rootParent1;
            size[rootParent1]+=size[rootParent2];
        }

    }

    public static void main(String[] args) {
        DSU_disjoint_sets_in_one_shot dsu= new DSU_disjoint_sets_in_one_shot(4);
        System.out.println("Total Components : " + dsu.components);

        // DSU BY RANK
        System.out.println("DSU BY RANK");
        System.out.println(dsu.findRootParent(0)==dsu.findRootParent(3));
        dsu.unionByRank(0, 3);
        System.out.println("Total Components : " + dsu.components);
        System.out.println(dsu.findRootParent(0)==dsu.findRootParent(3));

        // DSU BY SIZE
        System.out.println("DSU BY SIZE");
        System.out.println(dsu.findRootParent(0)==dsu.findRootParent(3));
        dsu.unionBySize(0, 3);
        System.out.println("Total Components : " + dsu.components);
        System.out.println(dsu.findRootParent(0)==dsu.findRootParent(3));

    }

}
