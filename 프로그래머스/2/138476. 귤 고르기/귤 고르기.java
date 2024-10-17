import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int num = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int tan : tangerine) {
            map.put(tan, map.getOrDefault(tan, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        for (int val : list) {
            if (num + val >= k) {
                answer++;
                break;
            } else {
                num += val;
                answer++;
            }
        }
        
        return answer;
    }
}