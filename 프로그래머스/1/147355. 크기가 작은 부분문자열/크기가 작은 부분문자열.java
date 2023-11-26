import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        String[] result = new String[t.length() - p.length() + 1];
        
        for(int i=0; i<t.length()-p.length()+1; i++) {
            result[i] = t.substring(i, p.length()+i);
            if(Long.parseLong(result[i]) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }
}