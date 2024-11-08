import java.util.HashSet;
import java.util.Set;

class Solution {
    
    static Set<Integer> primeNumbers = new HashSet<>();
    static boolean[] visited;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        // 모든 가능한 숫자 조합 생성
        dfs("", numbers);
        
        return primeNumbers.size();
    }

    // DFS로 모든 가능한 숫자 조합 생성
    public void dfs(String current, String numbers) {
        if (!current.isEmpty()) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) {
                primeNumbers.add(num);  // 소수라면 Set에 추가
            }
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers);
                visited[i] = false;  // 백트래킹
            }
        }
    }

    // 소수 판별 함수
    public boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}