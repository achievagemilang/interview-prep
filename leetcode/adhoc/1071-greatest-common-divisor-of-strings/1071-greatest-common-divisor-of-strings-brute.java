class Solution {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder divisor = new StringBuilder();

        if(str1.length() < str2.length()){
            divisor.append(str1);
        } else {
            divisor.append(str2);
        }

        while(!divisor.toString().equals("")){
            if(str1.length() % divisor.length() != 0 || str2.length() % divisor.length() != 0){
                divisor.deleteCharAt(divisor.length() - 1);
                continue;
            }

            boolean isEqual = true;

            for(int i=0; i<str1.length(); i+=divisor.length()){
                String toCompare = str1.substring(i, i+divisor.length());
                if(!toCompare.equals(divisor.toString())){
                    isEqual = false;
                    break;
                }
            }
            
            for(int i=0; i<str2.length(); i+=divisor.length()){
                String toCompare = str2.substring(i, i+divisor.length());
                if(!toCompare.equals(divisor.toString())){
                    isEqual = false;
                    break;
                }
            }

            if(!isEqual){
                divisor.deleteCharAt(divisor.length() - 1);
                continue;
            }

            return divisor.toString();

        }

        return "";
    
    }
}


/*
ABABAB / ABAB
ABAB starts with ? does the length 4 * 2 ?

brute force 
*/