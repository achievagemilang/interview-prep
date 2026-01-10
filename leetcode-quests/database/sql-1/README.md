# SQL Set 1

This directory contains solutions to various LeetCode SQL problems, primarily focusing on basic `SELECT`, `JOIN`, and `WHERE` clauses.

## Questions

### [1. Combine Two Tables (175)](https://leetcode.com/problems/combine-two-tables/)

**Problem Description:**
Write a solution to report the first name, last name, city, and state of each person in the `Person` table. If the address of a `personId` is not present in the `Address` table, report `null` instead.

**SQL Solution:**

```sql
SELECT firstName, lastName, city, state
FROM Person p
LEFT JOIN Address a ON p.personId = a.personId;
```

---

### [2. Employees Earning More Than Their Managers (181)](https://leetcode.com/problems/employees-earning-more-than-their-managers/)

**Problem Description:**
Write a solution to find the employees who earn more than their managers.

**SQL Solution:**

```sql
SELECT e1.name as Employee
FROM employee e1
LEFT JOIN employee e2 ON e1.managerId = e2.id
WHERE e1.salary > e2.salary;
```

---

### [3. Not Boring Movies (620)](https://leetcode.com/problems/not-boring-movies/)

**Problem Description:**
Write a solution to report the movies with an odd-numbered ID and a description that is not "boring". Return the result table ordered by `rating` in descending order.

**SQL Solution:**

```sql
SELECT id, movie, description, rating
FROM cinema
WHERE MOD(id, 2) = 1
AND description != 'boring'
ORDER BY rating DESC;
```

---

### [4. Find Customer Referee (584)](https://leetcode.com/problems/find-customer-referee/)

**Problem Description:**
Find the names of the customer that are not referred by the customer with `id = 2`.

**SQL Solution:**

```sql
SELECT name
FROM customer
WHERE referee_id IS NULL
OR referee_id != 2;
```

---

### [5. Employees Whose Manager Left the Company (1978)](https://leetcode.com/problems/employees-whose-manager-left-the-company/)

**Problem Description:**
Find the IDs of the employees whose salary is strictly less than `$30000` and whose manager left the company. When a manager leaves the company, their information is deleted from the `Employees` table, but the reports still have their `manager_id` set to the manager that left.
Return the result table ordered by `employee_id`.

**SQL Solution:**

```sql
SELECT employee_id
FROM Employees
WHERE salary < 30000
AND manager_id NOT IN (
    SELECT employee_id
    FROM Employees
)
ORDER BY employee_id ASC;
```
