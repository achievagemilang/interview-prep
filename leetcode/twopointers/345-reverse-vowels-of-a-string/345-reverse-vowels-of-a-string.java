class Solution {
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] ans = s.toCharArray();

        while (l < r) {
            while (l < r && !isVowel(ans[l])) {
                l++;
            }
            while (l < r && !isVowel(ans[r])) {
                r--;
            }

            char tmp = ans[l];
            ans[l] = ans[r];
            ans[r] = tmp;
            
            l++;
            r--;
        } 

        return new StringBuilder().append(ans).toString();
    }

    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o';
    }
}