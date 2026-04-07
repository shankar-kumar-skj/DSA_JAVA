package JAVA.SHASHCODE.LECTURE212;

import java.util.*;

public class Word_ladder_II_in_graph {

    // // LEETCODE 126
    // public List<String> getNeighbours(String word,HashSet<String>set){
    //     // O(N*M^2*26)
    //     List<String> neighbours=new ArrayList<>();
    //     for(int i=0;i<word.length();i++){
    //         for(char ch='a';ch<='z';ch++){
    //             if(ch==word.charAt(i)){
    //                 continue;
    //             }
    //             String newWord=word.substring(0,i)+ch+word.substring(i+1,word.length());
    //             if(set.contains(newWord)){
    //                 neighbours.add(newWord);
    //             }
    //         }
    //     }
    //     return neighbours;
    // }

    // public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    //     HashSet <String> set=new HashSet<>(wordList); // O(N)
    //     List<List<String>> res =new ArrayList<>();
    //     if(!set.contains((endWord))){
    //         return res;
    //     }
    //     List<String> dummy=new ArrayList<>();
    //     dummy.add(beginWord);
    //     Queue<List<String>> queue=new LinkedList<>();
    //     queue.offer(dummy);
    //     if(set.contains(beginWord)){
    //         set.remove(beginWord);
    //     }
    //     int level=0;
    //     int resLevel=-1;
    //     // O(N)
    //     while(!queue.isEmpty()){
    //         HashSet<String> useWords=new HashSet<>();
    //         int curLevelSize=queue.size();
    //         // level wise traversal
    //         for(int i=0;i<curLevelSize;i++){
    //             List<String> nodeList=queue.poll();
    //             String node=nodeList.get(nodeList.size()-1);
    //             if(node.equals(endWord)){
    //                 resLevel=level;
    //                 res.add(nodeList);
    //             }
    //             // adjList
    //             List<String> neighbours=getNeighbours(node,set);
    //             for(String word:neighbours){
    //                 if(set.contains(word)){
    //                     nodeList.add(word);
    //                     queue.offer(new ArrayList<>(nodeList));
    //                     nodeList.remove(word);
    //                     useWords.add(word);
    //                 }
    //             }
    //         }
    //         for(String visited: useWords){
    //             set.remove(visited);
    //         }
    //         if(level==resLevel){
    //             break;
    //         }
    //         level++;
    //     }

    //     return res;
    // }


    // // GFG CODE 
    // public List<String> getNeighbours(String word,HashSet<String>set){
    //     // O(N*M^2*26)
    //     List<String> neighbours=new ArrayList<>();
    //     for(int i=0;i<word.length();i++){
    //         for(char ch='a';ch<='z';ch++){
    //             if(ch==word.charAt(i)){
    //                 continue;
    //             }
    //             String newWord=word.substring(0,i)+ch+word.substring(i+1,word.length());
    //             if(set.contains(newWord)){
    //                 neighbours.add(newWord);
    //             }
    //         }
    //     }
    //     return neighbours;
    // }

    // public ArrayList<ArrayList<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    //     HashSet <String> set=new HashSet<>(wordList); // O(N)
    //     ArrayList<ArrayList<String>> res =new ArrayList<>();
    //     if(!set.contains((endWord))){
    //         return res;
    //     }
    //     ArrayList<String> dummy=new ArrayList<>();
    //     dummy.add(beginWord);
    //     Queue<ArrayList<String>> queue=new LinkedList<>();
    //     queue.offer(dummy);
    //     if(set.contains(beginWord)){
    //         set.remove(beginWord);
    //     }
    //     int level=0;
    //     int resLevel=-1;
    //     // O(N)
    //     while(!queue.isEmpty()){
    //         HashSet<String> useWords=new HashSet<>();
    //         int curLevelSize=queue.size();
    //         // level wise traversal
    //         for(int i=0;i<curLevelSize;i++){
    //             ArrayList<String> nodeList=queue.poll();
    //             String node=nodeList.get(nodeList.size()-1);
    //             if(node.equals(endWord)){
    //                 resLevel=level;
    //                 res.add(nodeList);
    //             }
    //             // adjList
    //             List<String> neighbours=getNeighbours(node,set);
    //             for(String word:neighbours){
    //                 if(set.contains(word)){
    //                     nodeList.add(word);
    //                     queue.offer(new ArrayList<>(nodeList));
    //                     nodeList.remove(word);
    //                     useWords.add(word);
    //                 }
    //             }
    //         }
    //         for(String visited: useWords){
    //             set.remove(visited);
    //         }
    //         if(level==resLevel){
    //             break;
    //         }
    //         level++;
    //     }

    //     return res;
    // }
    
    // public ArrayList<ArrayList<String>> findSequences(String startWord,
    //                                                   String targetWord,
    //                                                   String[] wordList) {
    //     // Code here
    //     List<String> wordsList=Arrays.asList(wordList);
    //     return findLadders(startWord,targetWord,wordsList);
        
        
    // }
    
    
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

    public ArrayList<ArrayList<String>> findLadders(String beginWord, String endWord, HashSet<String> set) {
        ArrayList<ArrayList<String>> res =new ArrayList<>();
        if(!set.contains((endWord))){
            return res;
        }
        ArrayList<String> dummy=new ArrayList<>();
        dummy.add(beginWord);
        Queue<ArrayList<String>> queue=new LinkedList<>();
        queue.offer(dummy);
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        int level=0;
        int resLevel=-1;
        // O(N)
        while(!queue.isEmpty()){
            HashSet<String> useWords=new HashSet<>();
            int curLevelSize=queue.size();
            // level wise traversal
            for(int i=0;i<curLevelSize;i++){
                ArrayList<String> nodeList=queue.poll();
                String node=nodeList.get(nodeList.size()-1);
                if(node.equals(endWord)){
                    resLevel=level;
                    res.add(nodeList);
                }
                // adjList
                List<String> neighbours=getNeighbours(node,set);
                for(String word:neighbours){
                    if(set.contains(word)){
                        nodeList.add(word);
                        queue.offer(new ArrayList<>(nodeList));
                        nodeList.remove(word);
                        useWords.add(word);
                    }
                }
            }
            for(String visited: useWords){
                set.remove(visited);
            }
            if(level==resLevel){
                break;
            }
            level++;
        }

        return res;
    }
    
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        HashSet <String> set=new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }
        return findLadders(startWord,targetWord,set);
        
        
    }

}
