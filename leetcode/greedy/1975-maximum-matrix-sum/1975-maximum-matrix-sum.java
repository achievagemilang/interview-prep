class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long minVal = Long.MAX_VALUE;
        int negatives = 0;
        long sum = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                minVal = Math.min(minVal, Math.abs(matrix[i][j]));
                
                if(matrix[i][j] < 0){
                    negatives++;
                }

                sum += Math.abs(matrix[i][j]);
            }

        }
        if(negatives % 2 == 1){
            sum -= 2 * minVal;
        }
        return sum;
    }
}