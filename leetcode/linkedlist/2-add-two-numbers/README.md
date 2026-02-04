# Add Two Numbers

## Problem Description

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

## Examples

**Example 1:**

```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
```

**Example 2:**

```
Input: l1 = [0], l2 = [0]
Output: [0]
```

**Example 3:**

```
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
```

## Solution Approach

The problem asks us to add two numbers represented by linked lists in reverse order. This is similar to how we perform addition manually, starting from the least significant digit (which is the head of the list).

We iterate through both linked lists simultaneously, maintaining a `carry` variable.

1.  Initialize a dummy head node to simplify result list construction.
2.  Loop while `l1` is not null, `l2` is not null, or `carry` is non-zero.
3.  At each step, get the values from `l1` and `l2` (or 0 if null).
4.  Calculate `sum = val1 + val2 + carry`.
5.  Update `carry = sum / 10`.
6.  Create a new node with `sum % 10` and append it to our result list.
7.  Move pointers forward.

## Complexity Analysis

- **Time Complexity:** $O(\max(N, M))$, where $N$ and $M$ are the lengths of `l1` and `l2`. We iterate at most $\max(N, M) + 1$ times.
- **Space Complexity:** $O(\max(N, M))$ for the new linked list.

## Code Structure

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}
```
