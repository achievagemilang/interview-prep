import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue; 
                
                if (words[i].charAt(0) != words[j].charAt(0)) continue;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    
                    if (words[i].charAt(3) != words[k].charAt(0)) continue;

                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k) continue; 

                        if (words[l].charAt(0) != words[j].charAt(3)) continue;
                        
                        if (words[l].charAt(3) != words[k].charAt(3)) continue;

                        List<String> validSquare = new ArrayList<>();
                        validSquare.add(words[i]); 
                        validSquare.add(words[j]); 
                        validSquare.add(words[k]); 
                        validSquare.add(words[l]); 
                        result.add(validSquare);
                    }
                }
            }
        }

        Collections.sort(result, (a, b) -> {
            for (int x = 0; x < 4; x++) {
                int cmp = a.get(x).compareTo(b.get(x));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        });

        return result;
    }
}