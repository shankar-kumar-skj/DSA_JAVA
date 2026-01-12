package JAVA.SHASHCODE.LECTURE153;

import java.util.ArrayList;
import java.util.Arrays;
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

    // 45 min
}
