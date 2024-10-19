import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> bridge = new LinkedList<>();
        int totalWeight = 0; // 총 무게
        int time = 0; // 소요시간
        int index = 0; // 대기트럭
        
        for(int i=0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        while(!bridge.isEmpty()) {
            time++;
            
            totalWeight -= bridge.poll();
            
            // 다음트럭 확인
            if(index < truck_weights.length) {
                if(totalWeight + truck_weights[index] <= weight) {
                    bridge.add(truck_weights[index]);
                    totalWeight += truck_weights[index];
                    index++;
                } else {
                    bridge.add(0);
                }
            }
        }
        return time;
    }
}