# Weekly Contest 487

## Q1. Count Monobit Integers

### Problem Description

Given an integer `n`, count how many "monobit" integers exist less than or equal to `n`. A monobit integer is an integer whose binary representation consists of all 1s (e.g., 1, 3, 7, 15...).

### Solution Approach

Iterate through numbers that are formed by all 1s (1, 11, 111 in binary) and count how many are $\le n$.

- Start with `monobit = 1`.
- In each step, generate the next monobit integer using `(monobit << 1) | 1`.
- Continue as long as `monobit <= n`.

### Code Structure

```java
class Solution {
    public int countMonobit(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;

        int numberOfOnes = 0;
        int monobit = 1;

        while(monobit <= n){
            numberOfOnes++;
            monobit = (monobit << 1) | 1;
        }

        return 1 + numberOfOnes;
    }
}
```

---

## Q2. Final Element After Subarray Deletions

### Problem Description

Given an array `nums`, determine the final element remaining after a specific deletion process where Alice and Bob take turns removing subarrays.

### Solution Approach

Observation from the code reveals a simple game theory outcome:

- The answer is simply the maximum of the first and last element: `Math.max(nums[0], nums[n - 1])`.

### Code Structure

```java
class Solution {
    public int finalElement(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0], nums[n - 1]);
    }
}
```

---

## Q3. Design Ride Sharing System

### Problem Description

Design a system that manages riders and drivers, allowing for:

- Adding riders and drivers.
- Matching a driver with a waiting rider.
- Cancelling a ride request.

### Solution Approach

Use queues to manage available drivers and riders, and sets to track status.

- **Riders**: Stored in a `Deque`.
- **Drivers**: Stored in a `Deque`.
- **Match**: Poll from both queues. If a rider was cancelled, skip them and poll again.
- **Cancel**: Add rider ID to a `cancelledRiders` set.

### Code Structure

```java
class RideSharingSystem {
    Deque<Integer> riders;
    Deque<Integer> drivers;
    Set<Integer> cancelledRiders;
    Set<Integer> waitingRiders;

    public RideSharingSystem() {
        riders = new ArrayDeque<>();
        drivers = new ArrayDeque<>();
        cancelledRiders = new HashSet<>();
        waitingRiders = new HashSet<>();
    }

    public void addRider(int riderId) {
        riders.add(riderId);
        waitingRiders.add(riderId);
    }

    public void addDriver(int driverId) {
        drivers.add(driverId);
    }

    public int[] matchDriverWithRider() {
        while(!riders.isEmpty() && cancelledRiders.contains(riders.peek())){
            cancelledRiders.remove(riders.poll());
        }

        if(riders.isEmpty() || drivers.isEmpty())
            return new int[]{-1, -1};

        int r = riders.poll();
        int d = drivers.poll();
        waitingRiders.remove(r);

        return new int[]{d, r};
    }

    public void cancelRider(int riderId) {
        if(waitingRiders.contains(riderId)){
            cancelledRiders.add(riderId);
        }
    }
}
```
