import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static Set<String> results; // 중복을 제거하기 위해 Set 사용
    
    static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        map = new int[5][5];
        results = new HashSet<>();
        
        // 입력 받기
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 모든 위치에서 시작하여 DFS 수행
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 1, String.valueOf(map[i][j])); // 시작 위치와 첫 번째 숫자
            }
        }
        
        // 결과 출력
        System.out.println(results.size());
        
        br.close();
    }
    
    // DFS 함수
    static void dfs(int y, int x, int depth, String current) {
        if (depth == 6) {
            results.add(current); // 여섯 자리 수 추가
            return;
        }
        
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5) {
                dfs(ny, nx, depth + 1, current + map[ny][nx]); // 다음 칸으로 이동
            }
        }
    }
}