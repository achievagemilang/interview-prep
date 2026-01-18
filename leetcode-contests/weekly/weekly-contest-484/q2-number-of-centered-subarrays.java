class Solution {
    public int centeredSubarrays(int[] nums) {
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            int sum = 0;
            Set<Integer> seen = new HashSet<>();

            for(int j=i; j<nums.length; j++){
                int n = nums[j];
                sum += n;
                seen.add(n);
                
                if(seen.contains(sum)){
                    ans++;
                }

                
            }
        }

        return ans;
    }
}