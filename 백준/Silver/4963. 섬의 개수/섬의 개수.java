import java.util.*;
import java.io.*;

class Main {

    static boolean map[][];
    static boolean visited[][];
    static int w, h;
    static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public static void dfs(int y, int x) {
        visited[y][x] = true;
        
        for(int i=0; i<8; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            
            if(newY > 0 && newY <= h && newX > 0 && newX <= w) {
                if(map[newY][newX] && !visited[newY][newX]) {
                    dfs(newY, newX);
                }
            }
        }
        
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
        
            w = Integer.parseInt(st.nextToken()); // 너비
            h = Integer.parseInt(st.nextToken()); // 높이
        
            if(w==0 && h==0) break; // 입력의 마지막

            map = new boolean[h+1][w+1];
            visited = new boolean[h+1][w+1];
        
            for(int i=1; i<=h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
                }
            }
            
            // dfs 수행
            int answer = 0;
            for(int i=1; i<=h; i++) {
                for(int j=1; j<=w; j++) {
                    if(map[i][j] && !visited[i][j]) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }
            
            // 출력하기
            bw.write(String.valueOf(answer));
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}