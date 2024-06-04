class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n/2; i++) {
            int total = 0;
            for(int j=i; i<=n/2; j++) {
                total += j;
                if(total == n) {
                    answer++;
                    break;
                } else if(total > n) {
                    break;
                }
            }
        }
        return answer+1;
    }
}