import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> resultSet = new HashSet<>();
        
        for(int i = 0; i< nums.length; i ++) {
            resultSet.add(nums[i]);
        }
        
        int max = nums.length / 2;
        
        answer = resultSet.size();
        
        if(answer > max) {
            answer = max;
        }

        return answer;
    }
}