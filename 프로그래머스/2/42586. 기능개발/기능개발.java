import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
             
        List<Integer> answer = new ArrayList<>();
        
        List<Integer> dayList = new ArrayList<>();
        
        
        // 각 작업의 완료 날짜 계산
        for (int i = 0; i < progresses.length; i++) {
            int remainingProgress = 100 - progresses[i];
            int days = (int) Math.ceil((double) remainingProgress / speeds[i]);
            dayList.add(days);
        }
        
        // 배포 시 함께 배포되는 기능 수 계산
        int currentMaxDay = dayList.get(0); // 첫 번째 작업이 완료되는 날
        int count = 1; // 배포되는 기능의 수
        
        for (int i = 1; i < dayList.size(); i++) {
            if (dayList.get(i) <= currentMaxDay) {
                // 현재 작업이 앞선 작업과 함께 배포될 수 있는 경우
                count++;
            } else {
                // 현재 작업이 앞선 작업보다 늦게 완료되어 따로 배포되어야 하는 경우
                answer.add(count);
                count = 1; // 새로운 배포 그룹 시작
                currentMaxDay = dayList.get(i); // 새로운 배포 기준일 갱신
            }
        }
        
        // 마지막으로 남은 배포 그룹 추가
        answer.add(count);
        
        return answer;
    }
}