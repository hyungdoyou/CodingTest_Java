import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        Integer sum = 0;
        queue.add(0);
        
        for(int i=0; i<numbers.length; i++) {
            for(int j=0; j<queue.size(); j++) {
                sum = queue.poll();
                queue.add(sum + numbers[i]);
                queue.add(sum - numbers[i]);   
            }
        }
        
        while(!queue.isEmpty()){
            Integer result = queue.poll();
            if(result == target) {
                answer = answer+1;
            }
        }
        return answer;
    }
}