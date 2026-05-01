package JAVA.SHASHCODE.LECTURE243;

// TC => O(N*L + K)

class TrieNode{
    TrieNode trieNode[];
    int count;
    TrieNode(){
        trieNode = new TrieNode[26];
        count=0;
    }

    boolean containsChar(char ch){
        return trieNode[ch-'a']!=null;
    }

    void add(char ch){
        trieNode[ch -'a'] = new TrieNode();
    }

    TrieNode getChar(char ch){
        return trieNode[ch -'a'];
    }

    void increamentCount(){
        count++;
    }

    int getCount(){
        return count;
    }
}
public class Longest_common_prefix_using_trie_in_java {
    public String longestCommonPrefix(String[] strs) {
        TrieNode root=new TrieNode();
        // insert in tries
        for(String word: strs){
            TrieNode temp=root;
            for(char ch : word.toCharArray()){
                if(!temp.containsChar(ch)){
                    temp.add(ch);
                }
                temp=temp.getChar(ch);
                temp.increamentCount();
            }
        }
        TrieNode temp=root;
        int n = strs.length;
        int count=0;
        for(char ch : strs[0].toCharArray()){
            temp = temp.getChar(ch);
            if(temp.getCount()!=n){
                break;
            }
            count++;
        }
        return strs[0].substring(0,count);
    }
}
