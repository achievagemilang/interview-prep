class Solution {
    public int prefixConnected(String[] words, int k) {
        if(words == null || k <= 0){
            return 0;
        }
        
        Map<String, Integer> prefixCounts = new HashMap<>();

        for(String w: words){
            if(w == null || w.length() < k){
                continue;
            }

            String pref = w.substring(0, k);

            int currentCount = prefixCounts.getOrDefault(pref, 0);
            prefixCounts.put(pref, currentCount + 1);
        }

        int groupCounts = 0;
        for(int count: prefixCounts.values()){
            if(count >= 2){
                groupCounts++;
            }
        }

        return groupCounts;
    }
}