class Solution {
    int answer;
    int target;
    int[] numbers;

        // 깊이 우선 탐색
    public void dfs(int index, int sum) {
        // 탈출 조건 : 마지막 노드까지 탐색한 경우
        if (index == numbers.length) {
            if (target == sum) {
                answer++; // 타겟 숫자와 합계가 같으면 방법의 수 증가
            }
            return; // 탐색 종료
        }

        // 수행동작
        // 해당 노드의 값을 더하고 다음 깊이 탐색
        dfs(index + 1, sum + numbers[index]);
        // 해당 노드의 값을 빼고 다음 깊이 탐색
        dfs(index + 1, sum - numbers[index]);
    }
    
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0); // DFS 탐색 시작
        return answer; // 최종 결과 반환
    }
}