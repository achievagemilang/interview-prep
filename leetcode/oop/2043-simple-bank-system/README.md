# Simple Bank System

## Problem Description

Design a bank system that supports the following operations:

- **Transfer** money between two accounts
- **Deposit** money into an account
- **Withdraw** money from an account

Each operation should validate account existence and sufficient balance.

## Examples

**Example:**

```
Input:
["Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"]
[[[10, 100, 20, 50, 30]], [3, 10], [5, 1, 20], [5, 20], [3, 4, 15], [10, 50]]

Output:
[null, true, true, true, false, false]
```

## Solution Approach

Simple OOP design with an array to store account balances.

1. **Constructor**: Initialize accounts array from input.
2. **Transfer**: Validate both accounts exist and source has sufficient funds.
3. **Deposit**: Validate account exists, add money.
4. **Withdraw**: Validate account exists and has sufficient funds.

All operations use 1-based indexing as per problem specification.

## Complexity Analysis

- **Time Complexity:** $O(1)$ for all operations.
- **Space Complexity:** $O(N)$ where $N$ is the number of accounts.

## Code Structure

```java
class Bank {
    long[] accounts;

    public Bank(long[] balance) {
        this.accounts = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 > this.accounts.length || account2 > this.accounts.length
           || account1 < 0 || account2 < 0){
            return false;
        }
        if(this.accounts[account1-1] < money){
            return false;
        }
        this.accounts[account2-1] += money;
        this.accounts[account1-1] -= money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if(account > this.accounts.length || account < 0){
            return false;
        }
        this.accounts[account-1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account > this.accounts.length || account < 0){
            return false;
        }
        if(this.accounts[account-1] < money){
            return false;
        }
        this.accounts[account-1] -= money;
        return true;
    }
}
```
