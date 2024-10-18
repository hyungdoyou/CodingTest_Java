SELECT
    A.CAR_ID,
    A.CAR_TYPE,
    ROUND((A.DAILY_FEE - (A.DAILY_FEE * (C.DISCOUNT_RATE / 100))) * 30) AS FEE
FROM CAR_RENTAL_COMPANY_CAR A
LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B 
    ON A.CAR_ID = B.CAR_ID 
    AND B.END_DATE >= '2022-11-01' 
    AND B.START_DATE <= '2022-12-01'
JOIN (
    SELECT CAR_TYPE, DISCOUNT_RATE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE CAR_TYPE IN ('세단', 'SUV') 
      AND DURATION_TYPE = '30일 이상'
) AS C ON A.CAR_TYPE = C.CAR_TYPE
WHERE B.CAR_ID IS NULL  -- 해당 기간에 대여 기록이 없는 자동차만 선택
  AND ROUND((A.DAILY_FEE - (A.DAILY_FEE * (C.DISCOUNT_RATE / 100))) * 30) >= 500000
  AND ROUND((A.DAILY_FEE - (A.DAILY_FEE * (C.DISCOUNT_RATE / 100))) * 30) < 2000000
ORDER BY FEE DESC, A.CAR_TYPE ASC, A.CAR_ID DESC;