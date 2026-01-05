class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxVal = 0;
        List<Boolean> ans = new ArrayList<>();
        
        for(int i=0; i<candies.length; i++){
            maxVal = Math.max(maxVal, candies[i]);
        }

        for(int i=0; i<candies.length; i++){
            int n = candies[i] + extraCandies;
            if(n >= maxVal){
                ans.add(true);
            }else ans.add(false);
        }

        return ans;
    }
}