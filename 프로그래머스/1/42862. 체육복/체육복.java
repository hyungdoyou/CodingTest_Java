import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        Arrays.sort(reserve);
        Arrays.sort(lost);
        
        for(int i=0; i<reserve.length; i++) {
              for(int j=0; j<lost.length; j++) {
                  if(reserve[i] == lost[j]) {
                        answer = answer + 1;
                        reserve[i] = -1;
                        lost[j] = -1;
                        break;
                    }
              }
        }
        for(int i=0; i<reserve.length; i++) {
              for(int j=0; j<lost.length; j++) {
                  if(reserve[i] == lost[j] - 1 || reserve[i] == lost[j] + 1) {
                        answer = answer + 1;
                        reserve[i] = -1;
                        lost[j] = -1;
                        break;
                    }
              }
        }
    return answer;
    }
}