import java.util.*;
import java.io.*;

class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, start, end, answer;

    public static void dfs(int idx, int count) {
        visited[idx] = true;
        if(idx == end){
            answer = count;
            return;
        }

        for (int next : graph[idx]) {
            if (!visited[next]) {
                dfs(next, count + 1);
            }
        }
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
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = -1;

        int x, y;
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            
            graph[x].add(y);
            graph[y].add(x);
        }

        // 2. dfs(재귀함수 호출)
        dfs(start, 0);

        // 3. 출력
        bw.write(String.valueOf(answer));
        
        bw.close();
        br.close();
    }
}