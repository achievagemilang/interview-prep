class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        
        int lDiff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<arr.length-1; i++){
            int diff = arr[i+1] - arr[i];

            if(diff < lDiff){
                ans = new ArrayList<>();
                ans.add(Arrays.asList(arr[i], arr[i+1]));
            } else if (diff == lDiff){
                ans.add(Arrays.asList(arr[i], arr[i+1]));
            }
            lDiff = Math.min(lDiff, diff);
        }

        return ans;
    }
}