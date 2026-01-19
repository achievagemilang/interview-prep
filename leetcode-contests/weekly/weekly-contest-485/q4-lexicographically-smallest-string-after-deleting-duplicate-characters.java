import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

class Solution {
    public String lexSmallestAfterDeletion(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int[] remainingCounts = new int[26];
        for (char c : chars) remainingCounts[c - 'a']++;

        char[] nextDiff = new char[n];
        char lastDifferent = 0;
        for (int i = n - 1; i >= 0; i--) {
            nextDiff[i] = lastDifferent;
            if (i > 0 && chars[i] != chars[i - 1]) {
                lastDifferent = chars[i];
            }
        }

        int[] stackCounts = new int[26];
        Deque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char c = chars[i];
            remainingCounts[c - 'a']--;

            while (!st.isEmpty() && st.peek() > c) {
                char top = st.peek();
                boolean spareExists = (remainingCounts[top - 'a'] > 0 || stackCounts[top - 'a'] > 1);
                
                if (spareExists) {
                    st.pop();
                    stackCounts[top - 'a']--;
                } else {
                    break;
                }
            }

            if (!st.isEmpty() && st.peek() == c) {
                if (nextDiff[i] > c) {
                    st.push(c);
                    stackCounts[c - 'a']++;
                }
                continue;
            }

            st.push(c);
            stackCounts[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = st.descendingIterator(); // Iterates from bottom to top
        while (it.hasNext()) {
            sb.append(it.next());
        }

        return sb.toString();
    }
}