import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int n = topping.length;
        
        // 왼쪽과 오른쪽에서 각각 토핑 종류의 개수를 저장할 배열
        int[] leftCount = new int[n];
        int[] rightCount = new int[n];
        
        // 왼쪽에서부터 토핑 종류를 누적하여 계산
        Set<Integer> leftSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            leftSet.add(topping[i]);
            leftCount[i] = leftSet.size();
        }
        
        // 오른쪽에서부터 토핑 종류를 누적하여 계산
        Set<Integer> rightSet = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            rightSet.add(topping[i]);
            rightCount[i] = rightSet.size();
        }
        
        // 왼쪽과 오른쪽의 종류 개수가 같은 경우를 카운트
        for (int i = 0; i < n - 1; i++) {
            if (leftCount[i] == rightCount[i + 1]) {
                answer++;
            }
        }
        
        return answer;
    }
}