import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A); // A 배열을 오름차순으로 정렬
        Arrays.sort(B); // B 배열을 오름차순으로 정렬
        
        // 누적이 최소가 되는 값 = A 배열 오름차순 * B 배열 내림차순
        // A와 B의 길이는 같음
        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[B.length-1-i];
        }

        return answer;
    }
}