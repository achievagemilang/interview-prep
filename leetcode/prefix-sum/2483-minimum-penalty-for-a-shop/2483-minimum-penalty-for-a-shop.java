
class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] pref = new int[n + 1];
        int[] post = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (customers.charAt(i) == 'N' ? 1 : 0);
        }

        for (int i = n - 1; i >= 0; i--) {
            post[i] = post[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }

        int minPenalty = Integer.MAX_VALUE;
        int minPenaltyIndex = 0;

        for (int i = 0; i <= n; i++) {
            int penalty = pref[i] + post[i];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                minPenaltyIndex = i;
            }
        }

        return minPenaltyIndex;
    }
}

/*
Solution is to compute both prefix sum and postfix sum
What causes penalty -> N on the right side of closing hour
                    -> Y on the left side of closing hour

Therefore solution will compute all N on prefix sum and Y on postfix sum then add them to find the total penalty given closing hour pointer

Edge -> First and last position -> customers.length()

T(n): O(n)
S(n): O(n)

*/