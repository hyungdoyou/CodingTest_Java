import java.util.*;
import java.io.*;

class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    
    static int N;

    public static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 0; i < graph[idx].size(); i++){
            int next = graph[idx].get(i);
            if (!visited[next]){
                answer[next] = idx;
                dfs(next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 노드의 개수 N
        N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        visited = new boolean[N+1];
        answer = new int[N+1];

        int x, y;
        // 1. 각 노드의 부모 노드를 순서대로 출력한다.
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken()); 
            graph[y].add(x);
            graph[x].add(y);
        }

        // 2. dfs 시작 : 2번 노드
        dfs(1);
        
        for(int i=2; i<=N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        bw.close();
        br.close();
        
    }
}