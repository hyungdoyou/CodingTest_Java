-- 코드를 입력하세요
SELECT
    A.PRODUCT_ID,
    A.PRODUCT_NAME,
    A.PRICE * B.TOTAL_AMOUNT AS TOTAL_SALES
FROM FOOD_PRODUCT A
JOIN (
    SELECT PRODUCT_ID, SUM(AMOUNT) AS TOTAL_AMOUNT
    FROM FOOD_ORDER
    WHERE PRODUCE_DATE LIKE '2022-05%'
    GROUP BY PRODUCT_ID
) AS B ON A.PRODUCT_ID = B.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, A.PRODUCT_ID ASC;