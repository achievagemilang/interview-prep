# Merge Two Sorted Lists

## Problem Description

Merge two sorted linked lists and return it as a new sorted list.

## Examples

**Example 1:**

```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

**Example 2:**

```
Input: list1 = [], list2 = [0]
Output: [0]
```

## Solution Approach

Use a dummy node and two pointers to merge in sorted order.

1. Create a dummy node to simplify construction.
2. Compare heads of both lists, append smaller one.
3. Move pointer of the list we just took from.
4. Append remaining elements from non-empty list.

## Complexity Analysis

- **Time Complexity:** $O(N + M)$ — traverse both lists once.
- **Space Complexity:** $O(1)$ — reuse existing nodes.

## Code Structure

```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}
```
