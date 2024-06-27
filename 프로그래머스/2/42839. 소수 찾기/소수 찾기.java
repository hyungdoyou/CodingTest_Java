import java.util.*;
class Solution {
    Set<Integer> numberSet= new HashSet<>();
    
    public boolean isPrime(int num) {
        // 1. 0과 1은 소수가 아니다.
        if(num == 0 || num == 1)
            return false;
        
        // 2. 에라토스테네스의 체의 limit을 계산한다.
        int limit = (int)Math.sqrt(num);
        
        // 3. 에라토스테네스의 체에 따라 limit 까지만 배수 여부를 확인한다.
        for(int i=2; i<=limit; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    public void recursive(String comb, String others) {
        // 1. 현재 조합을 set에 추가한다. (중복값을 허용하지 않는 set 사용)
        if(!comb.equals("")) {
            numberSet.add(Integer.parseInt(comb));   
        }

        // 2. 남은 숫자 중 한개를 더 더해서 새로운 조합을 만든다.
        for(int i=0; i<others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0,i) + others.substring(i+1));
        }
    }
    public int solution(String numbers) {
        int answer = 0;

        // 1. 모든 숫자 조합을 만든다.
        recursive("", numbers);

        // 2. 그 중 소수의 개수를 센다.
        Iterator<Integer> it = numberSet.iterator(); // 반복자
        while(it.hasNext()) {
            int number = it.next(); // 다음 숫자를 한개씩 꺼냄
            if(isPrime(number))
                answer++;
        }
        
        
        // 3. 소수는 제곱근까지만 확인하면 된다. (에라토스테네스의 체)
        
        return answer;
    }
}