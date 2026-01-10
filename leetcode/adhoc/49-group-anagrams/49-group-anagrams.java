class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for(String s: strs){
            int[] count = new int[26];
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                count[c - 'a']++;
            }
            String k = Arrays.toString(count);
            List<String> v = mp.getOrDefault(k, new ArrayList<>());
            v.add(s);
            mp.put(k, v);
        } 

        List<List<String>> ans = new ArrayList<>();
        for(String k: mp.keySet()){
            ans.add(mp.get(k));
        }


        return ans;
    }
}