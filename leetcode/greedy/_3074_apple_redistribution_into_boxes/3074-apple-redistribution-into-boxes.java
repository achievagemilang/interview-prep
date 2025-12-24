package leetcode.adhoc._3074_apple_redistribution_into_boxes;

import java.util.Arrays;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);

        for(int i=0; i<capacity.length/2; i++){
            if(capacity.length-i-1 == i) continue;
            int tmp = capacity[i];
            capacity[i] = capacity[capacity.length-i-1];
            capacity[capacity.length-i-1] = tmp;
        }

        int sum = 0;
        for(int a: apple){
            sum+=a;
        }

        int boxes = 0;

        for(int c: capacity){
            sum-=c;
            boxes++;
            if(sum <= 0){
                return boxes;
            }
        }        

        return Integer.MAX_VALUE;
    }
}

/*
    My approach is simply to sort the capacity array descendingly then take each value iteratively.
    This way, we can get the maximum box we can store in the biggest box possible, inherently to decrease our total apples to be distributed.

    Edge cases:
    - When boxes isn't sufficient -> not possible, is being handled by the constraints
    - Empty -> not possible

    T(n) = O(n log n) -> Sorting
    S(n) = O(1)

    Much better way is to use bucket to store existing values from capacity. We can sacrifice space for O(n) complexity
*/