# Weekly Contest 485

## Q1. Vowel Consonant Score

### Problem Description

Calculate a score based on the vowels and consonants in a string. The details of the formula depend on the specific problem statement (e.g., typically `floor(vowels / consonants)` based on the provided code structure).

### Solution Approach

- Iterate through the string.
- Count vowels (`a`, `e`, `i`, `o`, `u`).
- Count consonants (letters that are not vowels).
- Compute the score: `floor(vowels / consonants)` (handling division by zero).

### Code Structure

```java
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
```

---

## Q2. Maximum Capacity Within Budget

### Problem Description

Given a budget, select machines to maximize total capacity. You can select one machine or a pair of machines such that their total cost is within the budget.

### Solution Approach

1. **Sort Machines**: Sort machines by cost to allow binary search.
2. **Prefix Max Capacity**: Precompute the maximum capacity available for any machine within the first `i` elements.
3. **Iterate**: For each machine `i`:
   - Consider it as a single machine.
   - If pairing, find the best partner `j < i` such that `cost[j] + cost[i] <= budget` using binary search. The best partner will be the one with the max capacity in the valid range `[0, highLimit]`, which we can get in $O(1)$ from our prefix array.

### Code Structure

```java
class Solution {
    // ... helper class Machine ...
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        // ... (sorting and prefix max calculation) ...
        for(int i=0; i<n; i++){
            // ... check single machine ...
            // ... binary search for best partner ...
        }
        return (int) maxTotalCapacity;
    }
}
```

---

## Q3. Design Auction System

### Problem Description

Design an auction system where users can place, update, and remove bids on items. You need to efficiently retrieve the highest bidder for an item.

### Solution Approach

- **Data Structures**:
  - `userBids`: Map `itemId -> {userId -> amount}` for fast lookup/update of user's current bid.
  - `leaderboards`: Map `itemId -> TreeSet<Bid>` to maintain bids sorted by amount (descending) and then userId (ascending) for tie-breaking.
- **Operations**:
  - `addBid`/`updateBid`: Update both the map and the TreeSet. Time $O(\log B)$ where $B$ is bids per item.
  - `removeBid`: Remove from both map and TreeSet. Time $O(\log B)$.
  - `getHighestBidder`: Retrieve first element from TreeSet. Time $O(1)$ (or $O(\log B)$ depending on implementation).

### Code Structure

```java
class AuctionSystem {
    private Map<Integer, Map<Integer, Integer>> userBids;
    private Map<Integer, TreeSet<Bid>> leaderboards;

    public void addBid(int userId, int itemId, int bidAmount) {
        // ... update logic ...
    }
    // ... other methods ...
}
```

---

## Q4. Lexicographically Smallest String After Deleting Duplicate Characters

### Problem Description

Given a string `s`, delete characters to remove duplicates such that the resulting string is lexicographically smallest. (Note: The specific constraints and operations depend on the exact problem, the provided solution uses a stack and tracks remaining counts).

### Solution Approach

Use a **monotonic-stack-like greedy approach**:

1. Count frequency of all characters.
2. Iterate through the string. For each character `c`:
   - Decrement its remaining count.
   - If `c` is smaller than stack top and stack top appears later (remaining count > 0), pop from stack.
   - Push `c` to stack if not already present (visited check).
3. Build result from stack.

### Code Structure

```java
class Solution {
    public String lexSmallestAfterDeletion(String s) {
        // ... frequency count ...
        // ... stack-based greedy loop ...
        return sb.toString();
    }
}
```
