import java.util.*;
import java.io.*;

class Main {

    final static int MAX = 50 + 10;
    static char map[][];
    static boolean visited[][];
    static int N, M;
    
    public static void dfs(int y, int x) {
        visited[y][x] = true;
        
        if (map[y][x] == '-' && map[y][x + 1] == '-') dfs(y, x + 1);
        else if (map[y][x] == '|' && map[y + 1][x] == '|') dfs(y + 1, x);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 가로 크기
        M = Integer.parseInt(st.nextToken()); // 세로 크기
        
        map = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];
        
        for(int i=1; i<=N; i++) {
            String str = br.readLine();
            for(int j=1; j<=M; j++) {
                map[i][j] = str.charAt(j-1);
            }
        }
        
        // dfs
        int answer = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    answer++;
                }
            }
        }
        
        bw.write(String.valueOf(answer));
        
        bw.close();
        br.close();
    }
}