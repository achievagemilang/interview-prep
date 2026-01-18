class Solution {
    public int vowelConsonantScore(String s) {
        int v = 0, c = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'i', 'u', 'e', 'o'));

        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);

            if(vowels.contains(ch)){
                v++;
            }else if(Character.isLetter(ch)){
                c++;
            }
        }

        if(c > 0) return (int) Math.floor(v/c);
        return 0;
    }
}