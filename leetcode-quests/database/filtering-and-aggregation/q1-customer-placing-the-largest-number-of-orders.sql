SELECT customer_number
FROM orders
GROUP BY customer_number
HAVING COUNT(customer_number) >= ALL (
    SELECT COUNT(customer_number)
    FROM orders
    GROUP BY customer_number
);