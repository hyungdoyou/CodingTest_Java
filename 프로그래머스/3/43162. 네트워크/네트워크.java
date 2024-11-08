import java.util.*;

class Solution {
    
    static int[][] computers;
    static boolean[] visited;
    static int n;
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        
        this.n = n;
        this.computers = computers;
        
        visited = new boolean[n+1];
        
        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int idx) {
        visited[idx] = true;
        for(int i=0; i<n; i++) {
            if(visited[i] == false && computers[idx][i] == 1) {
                dfs(i);
            }
        }
    }
}