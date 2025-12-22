package leetcode.companies.traveloka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public static List<Integer> reassignedPriorities(List<Integer> priorities) {
        Set<Integer> uniqueSet = new HashSet<>(priorities);
        List<Integer> sortedUnique = new ArrayList<>(uniqueSet);
        Collections.sort(sortedUnique);
        
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < sortedUnique.size(); i++) {
            rankMap.put(sortedUnique.get(i), i + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        for (Integer p : priorities) {
            result.add(rankMap.get(p));
        }
        
        return result;
    }
}