class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String combined = str1 + str2;
        if(!combined.equals(str2 + str1)){
            return "";
        }

        return combined.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int a, int b){
        int prevB = b;
        while(b > 0){
            if(a % b == 0 && prevB % b == 0){
                return b;
            }
            b--;
        }
        return 1;
    }
}