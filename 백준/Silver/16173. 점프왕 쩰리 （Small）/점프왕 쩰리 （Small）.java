import java.util.*;
import java.io.*;

class Main {

    final static int MAX = 3 + 2;
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static boolean answer;
    static int dirY[] = {1, 0};
    static int dirX[] = {0, 1};
    
    public static void dfs(int y, int x) {
        visited[y][x] = true;
        
        if(y==N && x==N) {
            answer = true;
            return;
        }
        
        for(int i = 0; i < 2; i++){
            int newY = y + dirY[i] * map[y][x];
            int newX = x + dirX[i] * map[y][x];
            
            if(newY>0 && newY<=N && newX>0 && newX<=N) {
                if(visited[newY][newX] == false) {
                    dfs(newY, newX);   
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 출발지점 : 0, 0 / 도착지점 : N, N
        // 이동 가능방향 : 오른쪽과 아래
        // 젤리 승리 조건 : 가장 오른쪽 가장 아래에 도달 시
        
        N = Integer.parseInt(br.readLine());
        
        map = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];
        
        for(int i=1; i<=N; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(1, 1);
        
        if(answer) bw.write("HaruHaru");
        else bw.write("Hing");
        
        br.close();
        bw.close();
    }
}