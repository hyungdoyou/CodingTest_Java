import java.util.*;
import java.io.*;

class Main {

    static boolean map[][];
    static boolean visited[][];
    static int N, M;
    static int[] dirY = {1, -1, 0, 0};
    static int[] dirX = {0, 0, 1, -1};
    static boolean answer;
    
    public static void dfs(int y, int x) {
        if(y == N) {
            answer = true;
            return;
        }
        
        visited[y][x] = true;
        
        for(int i=0; i<4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            
            if(newY >= 0 && newY <= N && newX >= 0 && newX <= M) {
                if(map[newY][newX] && visited[newY][newX] == false) {
                    dfs(newY, newX);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new boolean[N+1][M+1];
        visited = new boolean[N+1][M+1];
        
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++)
                map[i][j] = (str.charAt(j - 1) == '0'); // 전류가 흐르는지 여부에 따라 true, false 입력
        }
        
        for(int j=1; j<=M; j++) {
            if(map[1][j] == true) {
                dfs(1, j);
            }
        }
        
        if(answer == true) bw.write("YES");
        else bw.write("NO");
        
        bw.close();
        br.close();
    }
}