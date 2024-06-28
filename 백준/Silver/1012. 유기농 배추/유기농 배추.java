import java.util.*;
import java.io.*;

class Main {

    static boolean map[][];
    static boolean visited[][];
    static int T, N, M, K;
    static int dirY[] = {1, -1, 0, 0};
    static int dirX[] = {0, 0, 1, -1};
    
    public static void dfs(int y, int x) {
        visited[y][x] = true;
        
        for(int i=0; i<4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            
            if (newY >= 0 && newY <= N && newX >= 0 && newX <= M) {
                if (map[newY][newX] && visited[newY][newX] == false) {
                    dfs(newY, newX);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
            N = Integer.parseInt(st.nextToken()); // 배추밭 세로길이
            K = Integer.parseInt(st.nextToken()); // 배추 위치 개수
            
            map = new boolean[N+1][M+1];
            visited = new boolean[N+1][M+1];
            
            // 1. map 정보 반영
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y+1][x+1] = true;
            }
            
            // 2. dfs 수행
            int answer = 0;
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=M; j++) {
                    if(map[i][j] && visited[i][j] == false) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }
            
            bw.write(String.valueOf(answer));
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}