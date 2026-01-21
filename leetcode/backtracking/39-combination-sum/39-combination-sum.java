package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        int sum = 0;
        int start = 0;
        Arrays.sort(candidates);

        dfs(candidates, target, ans, seq, sum, start);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> seq, int sum, int start){
        if(sum == target){
            ans.add(new ArrayList<>(seq));
            return;
        }
        if(sum < target){
            for(int i = start; i < candidates.length; i++){
                int n = candidates[i];
                sum += n;
                if(sum > target){
                    break;
                }
                seq.add(n);
                dfs(candidates, target, ans, seq, sum, i);
                seq.remove(seq.size() - 1);
                sum -= n;
            }
        }
    }
}
/*
We will use backtracking to find all possible combinations that sums up into the target.

However it'll be very slow as it means we try every possible combinations up until is not valid. Then smart pruning is needed when gained sum > target -> so we didn't calculate unnecessary things

We will start by smallest value then move into the highest possible, to do this candidates must be sorted.
Since the question of sequence must be unique we didn't need to use smaller number on node where higher number is being calculated

T(n) = O(N^(T/M)), where N is number of candidates, T is target, dan M is minimum value in candidates
S(n) = O(N) due to dfs recursive call

*/