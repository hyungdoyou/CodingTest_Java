import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        boolean flag = true;
        while (flag) {
            flag =false;
            for(int i=0; i<d.length; i++) {
                if(budget-d[i] >= 0) {
                    budget -= d[i];
                    answer++;
                } else {
                    flag =false;
                }
            }
        }
        return answer;
    }
}