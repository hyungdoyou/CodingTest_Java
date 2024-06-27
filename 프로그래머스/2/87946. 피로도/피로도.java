class Solution {
    int answer = -1;
    boolean visited[];

    public int solution(int k, int[][] dungeons) {
        // 1. 모든 경로를 탐색한다.(dfs 이용하자)
        visited = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    public void dfs(int depth, int k, int[][] dungeons) {
        for(int i=0; i<dungeons.length; i++) {
            // 방문하지 않았고 최소 피로도가 현재피로도 이하일때
            if(visited[i] == false && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(depth+1, k-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
}