class Solution {
    public long countPairs(String[] words) {
        Map<String, Integer> countCiphers = new HashMap<>();
        long ans = 0;
        
        for(String s: words){
            String normalized = cipher(s);
        
            if(countCiphers.containsKey(normalized)){
                ans += countCiphers.get(normalized);
            }
            countCiphers.put(normalized, countCiphers.getOrDefault(normalized, 0) + 1);
        }

        return ans;
    }

    private String cipher(String s){
        int shift = s.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            int newChar = (c - 'a' - shift + 26) % 26;
            sb.append((char)(newChar + 'a'));
        }

        return sb.toString();
    }
}