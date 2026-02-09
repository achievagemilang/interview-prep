# Reverse Linked List

## Problem Description

Given the `head` of a singly linked list, reverse the list and return the reversed list.

## Examples

**Example 1:**

```
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
```

**Example 2:**

```
Input: head = [1,2]
Output: [2,1]
```

## Solution Approach

Iteratively reverse pointers using two pointers (`prev` and `curr`).

1. Initialize `prev = null`, `curr = head`.
2. For each node:
   - Store `next = curr.next`.
   - Reverse pointer: `curr.next = prev`.
   - Move forward: `prev = curr`, `curr = next`.
3. Return `prev` as new head.

## Complexity Analysis

- **Time Complexity:** $O(N)$ — single pass.
- **Space Complexity:** $O(1)$ — only pointer variables.

## Code Structure

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;
    }
}
```
