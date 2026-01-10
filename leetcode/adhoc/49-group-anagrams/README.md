# Group Anagrams

## Problem Description

Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example 1:**

```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

**Example 2:**

```
Input: strs = [""]
Output: [[""]]
```

**Example 3:**

```
Input: strs = ["a"]
Output: [["a"]]
```

## Solution Approach: Categorize by Count

Two strings are anagrams if and only if their character counts (numbers of occurrences of each character) are the same. We can transform each string into a character count representation (e.g., a tuple or a stringified array) that serves as a unique key in a hash map.

### Algorithm

1.  Initialize a `HashMap` where the key is a string representation of the character counts, and the value is a list of strings (`List<String>`).
2.  Iterate through each string `s` in `strs`:
    - Initialize a count array of size 26 (for lowercase English letters).
    - Count the frequency of each character in `s`.
    - Convert the count array into a string key (e.g., using `Arrays.toString()`).
    - Add `s` to the list corresponding to this key in the map.
3.  Return the values of the map as a list of lists.

### Complexity Analysis

- **Time Complexity:** $O(N \cdot K)$, where $N$ is the length of `strs`, and $K$ is the maximum length of a string in `strs`. We traverse each string to count its characters.
- **Space Complexity:** $O(N \cdot K)$. The total information stored in our hash map is linear in the size of the input strings.

## Code Structure

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for(String s: strs){
            int[] count = new int[26];
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                count[c - 'a']++;
            }
            String k = Arrays.toString(count);
            List<String> v = mp.getOrDefault(k, new ArrayList<>());
            v.add(s);
            mp.put(k, v);
        }

        List<List<String>> ans = new ArrayList<>();
        for(String k: mp.keySet()){
            ans.add(mp.get(k));
        }


        return ans;
    }
}
```
