class Solution {
    public int solution(int n) {
        int answer = 0;
        int total[] = new int[n+1];
        total[0] = 0;
        total[1] = 1;
        
        for(int i=2; i<=n; i++) {
            total[i] = ( total[i-1] + total[i-2] ) % 1234567;
        }
        answer = total[n];
        return answer;
    }
}