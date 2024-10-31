import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        int[] dp = new int[12]; // n은 최대 11까지 가능하므로 dp 배열 크기는 12
        
        // 초기값 설정
        dp[1] = 1; // 1을 만드는 방법은 1가지
        dp[2] = 2; // 2를 만드는 방법은 2가지 (1+1, 2)
        dp[3] = 4; // 3을 만드는 방법은 4가지 (1+1+1, 1+2, 2+1, 3)
        
        // 점화식으로 dp 배열 채우기
        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        // 테스트 케이스별로 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }
        
        br.close();
        bw.close();
    }
}