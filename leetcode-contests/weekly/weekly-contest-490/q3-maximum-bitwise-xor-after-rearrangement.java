class Solution {
    public String maximumXor(String s, String t) {
        if (s == null || t == null || s.length() != t.length()){
            return "";
        }

        int onesInT = 0;

        for(int i=0; i<t.length(); i++){
            if(t.charAt(i) == '1') onesInT++;
        }

        int zerosInT = 0;
        
        for(int i=0; i<t.length(); i++){
            if(t.charAt(i) == '0') zerosInT++;
        }

        StringBuilder result = new StringBuilder();

        for(int i=0; i<t.length(); i++){
            char currentBit = s.charAt(i);

            if(currentBit == '1'){
                if(zerosInT > 0){
                    result.append('1');
                    zerosInT--;
                } else {
                    result.append('0');
                    onesInT--;
                }
            } else {
                if(onesInT > 0){
                    result.append('1');
                    onesInT--;
                } else {
                    result.append('0');
                    zerosInT--;
                }
            }
        }
        
        return result.toString();
    }
}©leetcode