class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int res = 0;
        int[] cnt = new int[26];

        for(int i=0; i<n; i++){
            Arrays.fill(cnt, 0);
            for(int j=i; j<n; j++){
                int freq = -1;
                cnt[s.charAt(j) - 'a']++;
                boolean isValid = true;

                for(int k=0; k<26; k++){
                    if(cnt[k] > 0){
                        if(cnt[s.charAt(j) - 'a'] != cnt[k]){
                            isValid = false;
                            break;
                        }
                    }
                } 

                if(isValid) res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }
}