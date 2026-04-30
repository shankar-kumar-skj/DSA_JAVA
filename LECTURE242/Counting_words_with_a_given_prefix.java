package JAVA.SHASHCODE.LECTURE242;

class TrieNode {

    TrieNode trieNode[];
    int count;

    TrieNode() {
        // c -> a - a => 2
        trieNode = new TrieNode[26];
        count = 0;
    }

    boolean containsChar(char ch) {
        return trieNode[ch - 'a'] != null;
    }

    void add(char ch) {
        trieNode[ch - 'a'] = new TrieNode();
    }

    TrieNode getChar(char ch) {
        return trieNode[ch - 'a'];
    }

    void increamentCount() {
        count++;
    }

    int getCount() {
        return count;
    }
}

//  TC => O(N * L + K)
public class Counting_words_with_a_given_prefix {
    public int prefixCount(String[] words, String pref) {
        // insert words in tries
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode temp = root;
            for (char ch : word.toCharArray()) {
                if (!temp.containsChar(ch)) {
                    temp.add(ch);
                }
                temp = temp.getChar(ch);
                temp.increamentCount();
            }
        }
        // check count of prefix
        TrieNode temp = root;
        for (char ch : pref.toCharArray()) {
            if (!temp.containsChar(ch)) {
                return 0;
            }
            temp = temp.getChar(ch);
        }
        return temp.getCount();
    }
}
