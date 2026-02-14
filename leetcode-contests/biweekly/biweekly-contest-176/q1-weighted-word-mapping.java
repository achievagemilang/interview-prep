class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        if (words == null || weights == null || weights.length != 26) return "";

        StringBuilder sb = new StringBuilder();

        for(String w: words){
            long currentWeight = calculateWeight(w, weights);
            int rem = (int) (currentWeight % 26);

            char mapped = (char)('z' - rem);

            sb.append(mapped);
        }

        return sb.toString();
    }

    private long calculateWeight(String w, int[] weights){
        long sum = 0;
        for(char c: w.toCharArray()){
            sum += weights[c - 'a'];
        }
        return sum;
    }
}