package JAVA.SHASHCODE.LECTURE211;

import java.util.*;

// beginWord="hit", endWord="cog"
// wordList = ["hot","dot","dog","lot","log","cog"]
// BFS => When we need to find minimum number of steps

// TC => O(N) + O(N*M^2*26)

public class Word_ladder_in_graph {

    public List<String> getNeighbours(String word,HashSet<String>set){
        // O(N*M^2*26)
        List<String> neighbours=new ArrayList<>();
        for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                if(ch==word.charAt(i)){
                    continue;
                }
                String newWord=word.substring(0,i)+ch+word.substring(i+1,word.length());
                if(set.contains(newWord)){
                    neighbours.add(newWord);
                }
            }
        }
        return neighbours;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet <String> set=new HashSet<>(wordList); // O(N)
        
        if(!set.contains((endWord))){
            return 0;
        }
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        int level=0;
        // O(N)
        while(!queue.isEmpty()){
            int curLevelSize=queue.size();
            // level wise traversal
            for(int i=0;i<curLevelSize;i++){
                String node=queue.poll();
                if(node.equals(endWord)){
                    return level+1;
                }
                // adjList
                List<String> neighbours=getNeighbours(node,set);
                for(String word:neighbours){
                    if(set.contains(word)){
                        queue.offer(word);
                        set.remove(word);
                    }
                }
            }
            level++;
        }

        return 0;
    }
}
