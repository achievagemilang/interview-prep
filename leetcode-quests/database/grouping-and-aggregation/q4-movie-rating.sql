(
    SELECT u.name AS results
    FROM movierating mr
    JOIN users u ON mr.user_id = u.user_id
    GROUP BY u.name
    ORDER BY COUNT(*) DESC, u.name ASC
    LIMIT 1
)
UNION ALL
(
    SELECT m.title AS results
    FROM movierating mr
    JOIN movies m ON mr.movie_id = m.movie_id
    WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
    GROUP BY m.title
    ORDER BY AVG(mr.rating) DESC, m.title ASC
    LIMIT 1
);