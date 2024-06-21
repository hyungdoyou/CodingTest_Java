import java.util.*;

class Solution {
    
     // 상하좌우 이동 가능 배열
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        // 목표지점까지 최단 거리 저장
        int[][] visited = new int[maps.length][maps[0].length]; 
        
        bfs(maps, visited);
        
        // 상대방 진영이 우측 하단에 위치했기 때문에 가장 마지막이 정답
        answer = visited[maps.length-1][maps[0].length-1]; 
        
        // answer가 0 일때 처리
        if(answer == 0){
            answer = -1;
        }
        return answer;
    }
    
    // bfs 구현하기
    public void bfs(int[][] maps, int[][] visited){
        int x = 0;
        int y = 0;
        visited[x][y] = 1; // 시작지점 거리
        
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        
        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int cX = current[0]; // 현재 위치의 행
            int cY = current[1]; // 현재 위치의 열
            
            for(int i = 0; i < 4; i++){ // 네방향 탐색
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                
                // 새로운 위치가 맵의 범위를 벗어나는지 확인
                if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1)
                    continue;
                
                // 벗어나지 않을 시, 방문한 곳이거나 막혀있는지 확인
                if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                    visited[nX][nY] = visited[cX][cY] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }
        }
    }
}