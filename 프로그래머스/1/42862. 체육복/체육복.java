import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // set 을 만듬
        Set<Integer> resSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();
        
        for(int i : reserve) {
            resSet.add(i);
        }
        
        for(int i : lost) {
            if(resSet.contains(i)) {
                resSet.remove(i);
            } else {
                lostSet.add(i);
            }
        }
        
        for(int i : resSet) {
            if(lostSet.contains(i-1)) {
                lostSet.remove(i-1);
            } else if(lostSet.contains(i+1)) {
                lostSet.remove(i+1);
            }
        }
        
        answer = n - lostSet.size();
        
        // 여분을 기준으로 앞뒤 학생에 체육복을 빌려줌
        
        // 총 학생수에서 lost에 남은 학생을 뺌
        return answer;
    }
}