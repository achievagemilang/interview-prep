class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Set<Integer> onBulbs = new TreeSet<>();

        for(int b: bulbs){
            if(onBulbs.contains(b)){
                onBulbs.remove(b);
            } else{
                onBulbs.add(b);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int b: onBulbs){
            ans.add(b);
        }

        return ans;
    }
}