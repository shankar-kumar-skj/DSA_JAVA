package JAVA.SHASHCODE.LECTURE153;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// recursion => explore all possibility and return to base case
// backtracking => explore and remove and if you find then return no need of going back to base case
public class Backtracking_all_concept {

    // leetcode 78
    // TC => N(2^N)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        subsequences(0, nums, current, res);
        return res;
    }
    
    private void subsequences(int index,int nums[],List<Integer> current,List<List<Integer>>res){
        // base case
        if(index==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        // include
        current.add(nums[index]);
        subsequences(index+1, nums, current, res);

        // remove
        current.remove(current.size()-1);

        // no pick
        subsequences(index+1, nums, current, res);
    }

    // leetcode 90
    // TC => N(logN) + N(2^N) ~ N(2^N) 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        subsequences1(0, nums, current, res);
        return res;
    }
    
    private void subsequences1(int index,int nums[],List<Integer> current,List<List<Integer>>res){
        // base case
        if(index==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        // include
        current.add(nums[index]);
        subsequences1(index+1, nums, current, res);

        // remove
        current.remove(current.size()-1);

        // no pick
        // remove all duplicates
        while((index+1)<nums.length && nums[index]==nums[index+1]){
            index++;
        }
        subsequences1(index+1, nums, current, res);
    }

    // leetcode => 46 permutations
    // TC => n* (n!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        permutations(nums, current, res);
        return res;
    }
    private void permutations(int nums[],List<Integer> current,List<List<Integer>> res){
        // base case
        if(current.size() ==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(current.contains(nums[i])){
                continue;
            }
            current.add(nums[i]);
            permutations(nums, current, res);
            current.remove(current.size()-1);
        }
    }

    // leetcode => 47 permutations II
    // TC => N(logN) + N* (N!) ~ N* (N!)
    // duplicates => index check and differentiate
    // same level => skip duplicates
    // same branch => allow duplicates

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        boolean seen[] =new boolean[nums.length];
        permutations1(nums,seen, current, res);
        return res;
    }
    private void permutations1(int nums[],boolean seen[],List<Integer> current,List<List<Integer>> res){
        // base case
        if(current.size() ==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            // if seen then skip
            if(seen[i]){
                continue;
            }

            if(i>0 && nums[i]==nums[i-1] && !seen[i-1]){
                continue;
            }
            
            seen[i]=true;
            current.add(nums[i]);
            permutations1(nums,seen, current, res);
            current.remove(current.size()-1);
            seen[i]=false;
        }
    }

    // Leetcode => 17
    // public List<String> letterCombinations(String digits) {
    //     HashMap<Character,String> map=new HashMap<>();
    //     map.put('2',"abc");
    //     map.put('3',"def");
    //     map.put('4',"ghi");
    //     map.put('5',"jkl");
    //     map.put('6',"mno");
    //     map.put('7',"pqrs");
    //     map.put('8',"tuv");
    //     map.put('9',"wxyz");
    //     List<String> res=new ArrayList<>();
    //     backtracking1(0,digits,res,"",map);
    //     return res;
    // }

    // // digits ="23"
    // private void backtracking1(int index,String digits,List<String> res,String current,HashMap<Character,String> map){
    //     // base case
    //     if(index == digits.length()){
    //         res.add(current);
    //         return;
    //     }
    //     char digit=digits.charAt(index);
    //     String letters=map.get(digit);
    //     for(int i=0;i<letters.length();i++){
    //         // current = current+letters.charAt(i);
    //         // backtracking1(index+1, digits, res, current, map);
    //         // current=current.substring(0,current.length()-1);
    //         // or
    //         backtracking1(index+1, digits, res, current, map);
    //     }
    // }

    // leetcode => 17
    // using string builder
    // TC => K^N (K = 3 or 4)
    // SC => 

    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");//k=3
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");//k=4
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res=new ArrayList<>();
        backtracking1(0,digits,res,new StringBuilder(""),map);
        return res;
    }

    // digits ="23"
    private void backtracking1(int index,String digits,List<String> res,StringBuilder current,HashMap<Character,String> map){
        // base case
        if(index == digits.length()){
            res.add(current.toString());
            return;
        }
        char digit=digits.charAt(index);
        String letters=map.get(digit);
        for(int i=0;i<letters.length();i++){
            current.append(letters.charAt(i));
            backtracking1(index+1, digits, res, current, map);
            current.deleteCharAt(current.length()-1);
        }
    }

    // LEETCODE => 22
    // TC => CATALEAN NUMBER (N=1 => 1,N=2 => 2, N=3 => 5, ...) =>(2N) X (4^N)/(N^(3/2)) => (4^N)/(N^(1/2))
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtracking3(res, new StringBuilder(""), n, 0, 0);
        return res;

    }
    private void backtracking3(List<String>res,StringBuilder current,int n,int open,int close){
        // base case
        if(open==n && close==n){
            res.add(current.toString());
            return;
        }
        if(open<n){
            current.append('(');
            backtracking3(res, current, n, open+1, close);
            current.deleteCharAt(current.length()-1);
        }
        if(close<n && close<open){
            current.append(')');
            backtracking3(res, current, n, open, close+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}
