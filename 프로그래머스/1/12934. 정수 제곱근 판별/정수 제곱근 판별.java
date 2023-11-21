class Solution {
    public long solution(long n) {
        long answer = 0;
        for(long x=1; x*x<=n; x++) {
            if(n == (x*x)) {
                answer = ((x+1)*(x+1));
                break;
            } else if(n != (x*x)) {
                answer = -1;
            }
        }
        return answer;
    }
}