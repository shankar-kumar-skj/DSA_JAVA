package JAVA.SHASHCODE.LECTURE193;

// Time Complexity :- 
// 1. Heapify => (Node to leaf) => O(log2 (N)) =>[Height]
// 2. Build Heap => O(N)
// 3. Extract Max (pop) => O(1) + O(log2 (N)) (Heapify)
// 4. Increase key => O(log2 (N)) (Bottom Up -> Height)
// 5. Decrease Key => O(log2 (N)) (Top Down -> Height)
// 6. Insert Element (push) => o(1) +  O(log2 (N)) (Bottom Up -> Height)
// 7. Heap Sort =>  O(N log2 (N))


// Complete Binary Tree (Naturally Balanced) + Heap Property
// 1. Min Heap => Value of Node is less than or equal to its child nodes.
// 2. Max Heap => Values of Node is greater than or equal to its child nodes.

// Array based implimintation (Converting array into Data Structure):-
// A. if parent Node is at ith index.
//    => Left child would be at 2*i+1;
//    => Right child would be at 2*i+2;
// B. if child node is at ith index,
//    => parebt will be at ceil(i/2) - 1;
// C. if height of a tree is 'h',max nodes is a complex Binary Tree will be (2^(h+1)) - 1 [h always start from 0]
// D. if there are N nodes, then height of complete Binary tree is floor (log2 (n))
// E. Range of leave Nodes in a Complete Binary Tree is floor(n/2) to n-1; (for '0' based indexing)


// Heap Operation :-
// Heapify => The process of rearranging the heap by recursively comparing a passed Node with its child node!
// => Heapify given tree for the index 0 [max heap]

// Build Heap :-
// => Given an array, convert it toa heap using heapify algorithm.

public class Heap_tree {
    int heapSize;
    int heap[];
    int capacity;

    Heap_tree (int arr[]){
        heap=arr;
        heapSize=arr.length;
        capacity=arr.length;
    }

    public void swap(int i,int j){
        heap[i]=heap[i]^heap[j];
        heap[j]=heap[i]^heap[j];
        heap[i]=heap[i]^heap[j];
    }
    // max heap heapify => if any node is less than it child then swap then heapify to another node.
    public void heapify(int index){
        int largest=index;
        int leftChildIndex=2*index+1;
        int rightChildIndex=2*index+2;
        if(leftChildIndex<heapSize && heap[leftChildIndex]>heap[largest]){
            largest=leftChildIndex;
        }
        if(rightChildIndex<heapSize && heap[rightChildIndex]>heap[largest]){
            largest=rightChildIndex;
        }
        if(largest!=index){
            swap(index, largest);
            heapify(largest);
        }
    }

    public void buildTree(){
        // N/2 to N-1 => LEAF NODE
        // 0 to (N/2 - 1) => NON LEAF NODE
        for(int index=(heapSize/2)-1;index>=0;index--){
            heapify(index);
        }
    }

    public void printTree(){
        for(int i=0;i<heapSize;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }

    // Extraction Max Element(Pop maximum Element)
    // => In some of websites, you will find that root and last node are swapped. Any of the approach is fine. We have discussed the mentioned approach during heap-sort implementation too.

    public int extractMax(){
        if(heapSize==0){
            System.out.println("Heap is empty");
            return -1;
        }
        int max=heap[0]; //store the root
        heap[0]=heap[heapSize-1];
        heapSize--; // delete the last node
        heapify(0);
        return max;
    }

    // Increase the key (make 5 to 10 like) 
    // => it only need to check the bottom Up Approach after increament if the parent is less value then leaf node then swap perform.

    public void increaseKey(int index,int newValue){
        if(index<0 || index>=heapSize || heap[index]>=newValue){
            System.out.println("Wrong Operation!");
            return;
        }
        heap[index]=newValue;
        while(index>0 && heap[index]>heap[(int)(Math.ceil(index/2.0)-1)]){
            swap(index,(int)(Math.ceil(index/2.0)-1));
            index=(int)(Math.ceil(index/2.0)-1);
        }
    }

    // Decrease the Key
    // => Heapify call after change the value
    public void decreaseKey(int index,int newValue){
        if(index<0 || index>=heapSize || heap[index]<=newValue){
            System.out.println("Wrong Operation!");
            return;
        }
        heap[index]=newValue;
        heapify(index);
    }

    // Increase Capacity Function
    public void increaseCapacity(){
        capacity*=2; // double logic
        int newHeap[]=new int[capacity];
        for(int i=0;i<heapSize;i++){
            newHeap[i]=heap[i];
        }
        heap=newHeap; // changing the refrence from heap to newHeap
    }

    // Inserting the new Value
    public void insert(int newValue){
        if(heapSize>=capacity){
            increaseCapacity();
        }
        heapSize++;
        heap[heapSize-1]=newValue;
        int index=heapSize-1;
        while(index>0 && heap[index]>heap[(int)(Math.ceil(index/2.0)-1)]){
            swap(index,(int)(Math.ceil(index/2.0)-1));
            index=(int)(Math.ceil(index/2.0)-1);
        }
    }

    // Heap Sort (Use heap property to sort an array)
    // -> Build Heap
    // -> Use extract Max (Max Heap) (Store at the end)
    public void extractMaxAndStore(){
        if(heapSize==0){
            System.out.println("Heap is empty");
            return;
        }
        int max=heap[0]; // store the root
        heap[0]=heap[heapSize-1];
        heap[heapSize-1]=max; // store in the last node
        heapSize--; // delete the last node
        heapify(0);
        return;
    }

    public int[] heapSort(){
        buildTree();
        int size=heapSize;
        for(int i=0;i<size;i++){
            extractMaxAndStore();
        }
        return heap;
    }

    public static void main(String args[]){
        int arr[]=new int[]{10,5,20,6,11};
        Heap_tree heap=new Heap_tree(arr);
        heap.buildTree();
        heap.printTree();
        System.out.println("Removed Max Element is -> "+heap.extractMax());
        heap.printTree();
        heap.increaseKey(2, 15);
        heap.printTree();
        heap.decreaseKey(4, 3);
        heap.printTree();
        heap.insert(4);
        heap.printTree();
        int result[]=heap.heapSort();
        System.out.println("Sorting In Ascending Order : ");
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" , ");
        }
        System.out.println("Sorting In Descending Order : ");
        for(int i=result.length-1;i<=0;i--){
            System.out.print(result[i]+" , ");
        }
    }
}
