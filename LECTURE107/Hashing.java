package JAVA.SHASHCODE.LECTURE107;

// https://www.youtube.com/watch?v=vB3WKXNH-v4&list=PLQ7ZAf76c0ZOl4ECSRnZHDW1L0UxV5djQ&index=1

// hash function :-
// 1. Division method => number mod size_of_hash_table
// 2. Mid square method => 
// 3. folding method

// collision Resolution (occurs in Division method)
// 1. Linear Probing
// => (h(x) + i) % size_of_hash_table
// => probe number => the position or place where the data store at hash table
// => Load Factor (alpha) => range -> (0 < alpha < 1) , alpha = (number of elements)/(size_of_hash_table)
// => Rehashing => if the load factor exceed its range then we doubly the size of the hash table.

//  Primary Clusturing => multiple element find due to probing
//  Secondary Clusturing => multiple element contains same probe numbers.
// if we Delete the hash data then we not directly delete that we write a symbol to identify the place is delete the place and that help to iterarte in the next down number of the hash table

// Quadratic Probing
// => h(x) + i^2
// => it resolve the primary clustering

// Doubly Hashing
// => (h1(x) + i*h2(x)) % size_of_hash_table
// => it resolve the primary as well as secondary clustering
// => but it is to complex 

// Seperate Chaining or Open Hashing
// => according to hash value function insertion at the head of linked list created and store the value.
// => storage not properly utilized.
// => Worst case searching => O(N)
// => Worst case delete => O(N)
// => Average time complexity => load factor

public class Hashing {
    
}
