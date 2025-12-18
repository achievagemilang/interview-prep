package adhoc;

import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        String[] ans = new String[n];

        for (int i=0; i<n; i++){
            int num = i+1;
            if(num % 3 == 0 && num % 5 == 0){
                ans[i] = "FizzBuzz";
            } else if (num % 3 == 0){
                ans[i] = "Fizz";
                
            } else if (num % 5 == 0){
                ans[i] = "Buzz";
                
            } else {
                ans[i] = String.valueOf(num);

            }
        }

        return Arrays.asList(ans);
    }
}
