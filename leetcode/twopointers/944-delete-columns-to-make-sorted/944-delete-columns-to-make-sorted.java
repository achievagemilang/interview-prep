package leetcode.twopointers;


class Solution {
    public int minDeletionSize(String[] strs) {
        if(strs.length <= 1) return 0;
        if(strs[0].length() == 0) return 0;

        int ans = 0;
        for(int i = 0; i < strs[0].length(); i++){
            char prev = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                char now = strs[j].charAt(i);
                if(prev > now){
                    ans++;
                    break;
                }
                prev = now;
            }
        }
        return ans;
    }
}

/*
  cba
  daf
  ghi

  What makes it in the same col?
  a[0][0]a[1][0]a[2][0]
  props:
  j -> is always same

  means we can get all rows, iterate by j to get each values in the string

  or in this case, can be get from s1.charAt(0) + s2.charAt(0) + .. sz.charAt(0)


  How to sort lexicographically? -> can use pointer
     abc
  1: lr
  2:  lr
  each should maintain cLeft < cRight if not it's not lexicographically sorted -> add it to ans

  steps:
  1. loop 0 -> s.length 
  2. check prev < now if, if not add to ans immendiately -> next iteration

  edge:
  - <= 1 length string means it sorted -> no need to remove

  T(n) = O(len(s)*len(strs))
  S(n) = O(1)
*/