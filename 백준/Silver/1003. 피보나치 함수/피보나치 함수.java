import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        // 0과 1이 출력되는 횟수를 저장할 DP 배열 생성
        int[] count_zero = new int[41];
        int[] count_one = new int[41];

        // 초기값 설정
        count_zero[0] = 1; // fibonacci(0)에서는 0이 1번 출력
        count_one[0] = 0;  // fibonacci(0)에서는 1이 0번 출력
        count_zero[1] = 0; // fibonacci(1)에서는 0이 0번 출력
        count_one[1] = 1;  // fibonacci(1)에서는 1이 1번 출력

        // DP 배열 채우기
        for (int i = 2; i <= 40; i++) {
            count_zero[i] = count_zero[i - 1] + count_zero[i - 2];
            count_one[i] = count_one[i - 1] + count_one[i - 2];
        }

        // 각 테스트 케이스에 대해 결과 저장
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(count_zero[N]).append(" ").append(count_one[N]).append("\n");
        }

        // 출력
        System.out.print(sb);
    }
}