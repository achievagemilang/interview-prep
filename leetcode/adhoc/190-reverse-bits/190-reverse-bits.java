class Solution {
    public int reverseBits(int n) {
        StringBuilder reversed = new StringBuilder();

        while(n > 0){
            int rem = n % 2;
            reversed.append(rem);
            n = n / 2;

        }

        while(reversed.length() < 32){
            reversed.append(0);
        }
        int res = 0;
        int p = 0;
        for(int i=reversed.length() - 1; i >= 0; i--){
            res += Math.pow(2, p) * (reversed.charAt(i) - '0');
            p++;
        }

        return res;
    }
}