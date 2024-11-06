import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i<priorities.length; i++) {
            queue.add(new int[] {priorities[i], i});
        }
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐의 첫 번째 프로세스 꺼내기
            boolean hasHigherPriority = false;
            
            // 큐 내에 더 높은 우선순위가 있는지 확인
            for (int[] process : queue) {
                if (process[0] > current[0]) { // 높은 우선순위 발견
                    hasHigherPriority = true;
                    break;
                }
            }
            
            if (hasHigherPriority) {
                // 더 높은 우선순위가 있으면 현재 프로세스를 다시 큐에 삽입
                queue.add(current);
            } else {
                // 현재 프로세스를 실행
                count++;
                if (current[1] == location) { // 목표 프로세스라면 실행 순서 반환
                    return count;
                }
            }
        }
        
        return -1;
    }
}