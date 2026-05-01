package JAVA.SHASHCODE.LECTURE245;

// XOR OPERATOR (^ )
// 0 ^ 0 => 0
// 0 ^ 1 => 1
// 1 ^ 0 => 1
// 1 ^ 1 => 0

// TC => O(2N * 32)

class TrieNode{
    TrieNode trieNode[];
    TrieNode(){
        trieNode = new TrieNode[2];
    }

    boolean containsBit(int ch){
        return trieNode[ch]!=null;
    }

    void add(int ch){
        trieNode[ch] = new TrieNode();
    }

    TrieNode getBit(int ch){
        return trieNode[ch];
    }
}

public class Maximum_xor_of_two_numbers_in_an_array_tries_and_bit_manipulation {
    public int findMaximumXOR(int[] nums){
        // insert all numbers
        TrieNode root=new TrieNode();
        for(int num : nums){
            TrieNode temp= root;
            for(int i=31;i>=0;i--){
                int bit = ((num >> i )& 1);
                if(!temp.containsBit(bit)){
                    temp.add(bit);
                }
                temp = temp.getBit(bit);
            }
        }
        int maxXOR= 0;
        // CHECK FOR MAX XOR
        for(int num : nums){
            TrieNode temp=root;
            int result = 0;
            for(int i=31;i>=0;i--){
                int bit = ((num>>i) &1);
                // 1 - bit => opposite bit
                if(temp.containsBit(1-bit)){
                    // result => 00100
                    // 1<<i => 00010
                    // result => 00010
                    result = result | (1<<i);
                    temp = temp.getBit(1-bit);
                }
                else{
                    // if opposite is not available than settle with actual value
                    temp = temp.getBit(bit);
                }
            }
            maxXOR = Math.max(maxXOR, result);
        }
        return maxXOR;
    }
}
