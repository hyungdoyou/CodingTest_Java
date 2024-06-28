import java.util.*;
import java.io.*;

class Main {
    
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M, answer;
    
    public static void dfs(int idx) {
        if(visited[idx] == true) {
            return;
        }
        
        visited[idx] = true;

        for (int next : graph[idx]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
        answer++;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine()); // 노드의 수
        M = Integer.parseInt(br.readLine()); // 간선의 수
        
        graph = new ArrayList[N + 1];
        visited = new boolean[N+1];
        
        // 각 노드별 graph 객체 생성
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int x, y;
        
        // 간선 정보를 입력받아 그래프를 구성
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[y].add(x);
            graph[x].add(y);
        }
        
        dfs(1);
        
        bw.write(String.valueOf(answer - 1));
        
        bw.close();
        br.close();
        
    }
}