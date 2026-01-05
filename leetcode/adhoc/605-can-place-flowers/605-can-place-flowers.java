class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] padded = new int[flowerbed.length + 2];

        for(int i=1; i<padded.length-1; i++){
            padded[i] = flowerbed[i - 1];
        }

        for(int i=1; i<padded.length-1; i++){
            if(padded[i - 1] == padded[i] && padded[i] == padded[i+1] && padded[i] == 0){
                padded[i] = 1;
                n--;
            }
            if(n == 0) return true;
        }

        return n <= 0;
    }
}