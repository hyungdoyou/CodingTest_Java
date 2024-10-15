SELECT
    B.EMP_NO,
    B.EMP_NAME,
    CASE
        WHEN AVG(C.SCORE) >= 96 THEN 'S'
        WHEN AVG(C.SCORE) >= 90 THEN 'A'
        WHEN AVG(C.SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    CASE
        WHEN AVG(C.SCORE) >= 96 THEN B.SAL * 0.2
        WHEN AVG(C.SCORE) >= 90 THEN B.SAL * 0.15
        WHEN AVG(C.SCORE) >= 80 THEN B.SAL * 0.1
        ELSE 0
    END AS BONUS
FROM HR_EMPLOYEES B
JOIN HR_GRADE C ON B.EMP_NO = C.EMP_NO
GROUP BY B.EMP_NO, B.EMP_NAME
ORDER BY B.EMP_NO;