class Solution {
    public String largestEven(String s) {
        int k = s.length() - 1;
        while(k >= 0){
            if(s.charAt(k) != '2'){
                k--;
            } else {
                break;
            }
        }

        if(k >= 0){
            return s.substring(0, k + 1);
        }
        return "";
    }
}