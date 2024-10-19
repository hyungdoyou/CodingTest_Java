import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        // 모든 시점에 대해 탐색
        for (int i = 0; i < prices.length; i++) {
            // 스택에 있는 가격 중, 현재 가격보다 큰 경우
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx; // 현재 시간에서 이전 시간 차이를 계산
            }
            stack.push(i); // 인덱스를 스택에 추가
        }

        // 끝까지 가격이 떨어지지 않은 경우 처리
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx; // 끝까지 가격이 떨어지지 않음
        }

        return answer;
    }
}