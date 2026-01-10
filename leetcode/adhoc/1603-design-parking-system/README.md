# Design Parking System

## Problem Description

Design a parking system for a parking lot. The parking lot has three kinds of parking spaces: big, medium, and small, with a fixed number of slots for each size.

Implement the `ParkingSystem` class:

- `ParkingSystem(int big, int medium, int small)` Initializes object of the `ParkingSystem` class. The number of slots for each parking space are given as part of the constructor.
- `bool addCar(int carType)` Checks whether there is a parking space of `carType` for the car that wants to get into the parking lot. `carType` can be of three kinds: big, medium, or small, which are represented by `1`, `2`, and `3` respectively. **A car can only park in a parking space of its** `carType`. If there is no space available, return `false`, else park the car in that size space and return `true`.

**Example 1:**

```
Input
["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
[[1, 1, 0], [1], [2], [3], [1]]
Output
[null, true, true, false, false]

Explanation
ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
parkingSystem.addCar(3); // return false because there is no available slot for a small car
parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.
```

## Solution Approach: Simulation

We can simulate the parking system by maintaining counters for each type of parking space. When a car arrives, we check if the corresponding counter is greater than 0. If it is, we decrement the counter and return `true`; otherwise, we return `false`.

### Algorithm

1.  **Initialization:** Store the initial capacity for `big`, `medium`, and `small` spaces in member variables.
2.  **addCar(carType):**
    - Check the `carType`.
    - If `carType` is 1 (Big): Check if `big > 0`. If so, decrement `big` and return `true`.
    - If `carType` is 2 (Medium): Check if `medium > 0`. If so, decrement `medium` and return `true`.
    - If `carType` is 3 (Small): Check if `small > 0`. If so, decrement `small` and return `true`.
    - If the condition is not met for the requested type, return `false`.

### Complexity Analysis

- **Time Complexity:** $O(1)$ for both the constructor and `addCar`. All operations involve basic arithmetic and comparisons.
- **Space Complexity:** $O(1)$. We only use a constant amount of space to store the capacities.

## Code Structure

```java
class ParkingSystem {
    int big, medium, small;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch(carType){
            case 1:
                if(this.big > 0){
                    this.big--;
                    return true;
                }
                break;
            case 2:
                if(this.medium > 0){
                    this.medium--;
                    return true;
                }
                break;
            case 3:
                if(this.small > 0){
                    this.small--;
                    return true;
                }
                break;
        }
        return false;
    }
}
```
