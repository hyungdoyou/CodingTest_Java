import java.util.*;

class Solution {
    
    boolean[] visited;  // 방문여부
    List<String> result = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        visited = new boolean[tickets.length];  // 초기화
        
        // 완전 탐색 시장
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(result);
        
        answer = result.get(0).split(" ");    
        return answer;
    }
    
    public void dfs(int idx, String start, String route, String[][] tickets) {
        // 탈출 조건
        if(idx == tickets.length) {
            result.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals(start) && visited[i] == false) {
                visited[i] = true;
                dfs(idx+1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}