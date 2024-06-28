import java.util.*;
import java.io.*;

class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int N, start, end, answer;

    public static void dfs(int idx, int count) {
        visited[idx] = true;
        if(idx == end){
            answer = count;
            return;
        }

        for (int i = 1; i <= N; i++)
            if (visited[i] == false && graph[idx][i])
                dfs(i, count + 1);
    }

    public static void main(String[] args) throws IOException{
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        int M = Integer.parseInt(br.readLine());
        
        // 1. graph에 연결 정보 채우기
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        answer = -1;

        int x, y;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[y][x] = true;
            graph[x][y] = true;
        }

        // 2. dfs(재귀함수 호출)
        dfs(start, 0);

        // 3. 출력
        bw.write(String.valueOf(answer));
        
        bw.close();
        br.close();
    }
}