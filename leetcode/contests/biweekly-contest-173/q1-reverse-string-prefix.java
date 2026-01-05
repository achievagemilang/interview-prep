
class Solution {
    public String reversePrefix(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for(int i=k-1; i>=0; i--){
            char c = s.charAt(i);
            sb.append(c);
        }

        if(k < s.length()){
            sb.append(s.substring(k));
        }

        return sb.toString();
    }
}