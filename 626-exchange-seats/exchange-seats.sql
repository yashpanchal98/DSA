SELECT 
    CASE 
        WHEN ID % 2 = 0 THEN ID - 1
        WHEN ID % 2 != 0 AND ID = (SELECT COUNT(*) FROM SEAT) THEN ID
        ELSE ID + 1
    END AS id,
    student
FROM SEAT
ORDER BY id;