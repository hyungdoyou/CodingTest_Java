class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 방문했는지 여부를 확인하기 위한 배열 선언
        Boolean visited[] = new Boolean[computers.length];
        
        // 처음에는 모두 방문 안한 것으로 초기화
        for(int i=0; i<visited.length; i++) {
            visited[i] = false;
        }

        // dfs 구현
        for(int i=0; i<computers.length; i++) {
            if(visited[i] == false) { // 아직 방문전이라면
                answer++;
                dfs(i, visited, computers);                
            }
        }
                
        return answer;
    }
    
    public void dfs(int i, Boolean[] visited, int[][] computers) {
        visited[i] = true; // 현재 노드는 방문으로 변경
        
        for(int j=0; j<computers.length; j++) {
            if(visited[j]==false && computers[i][j]==1) {
                dfs(j, visited, computers);
            }
        }
    }
}