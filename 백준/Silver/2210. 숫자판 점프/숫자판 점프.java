import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static Set<String> result;
    
    static int[] dirY = {1, -1, 0, 0};
    static int[] dirX = {0, 0, 1, -1};
    
    public static void dfs(int y, int x, int depth, String current) {
        // 탈출
        if(depth == 6) {
            result.add(current);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            
            if (newY >= 1 && newY <= 5 && newX >= 1 && newX <= 5) {
                    dfs(newY, newX, depth+1, current + map[newY][newX]);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        map = new int[6][6];
        result = new HashSet<>();
        
        // 입력 처리
        for (int i = 1; i <= 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // DFS 수행
        int answer = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                    dfs(i, j, 1, String.valueOf(map[i][j])); // 시작 위치와 첫 번째 숫자
            }
        }
        
        // 정답 출력
        bw.write(String.valueOf(result.size()));
        
        // 자원 해제
        br.close();
        bw.close();
    }
}