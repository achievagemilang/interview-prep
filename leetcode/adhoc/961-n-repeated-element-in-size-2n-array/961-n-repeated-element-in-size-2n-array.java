import java.util.HashMap;
import java.util.Map;

class Solution {
    public int repeatedNTimes(int[] nums) {
        if(nums.length % 2 != 0) return -1;
        int n = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) == n){
                return nums[i];
            }
        }

        return -1;
    }
}