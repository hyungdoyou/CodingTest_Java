class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long[] arr = new long[20000000];
        if( a <= b) {
            arr[0] = a;
            for(int i=1; i<=b-a; i++) {
                arr[i] = a+i;
            }
            for(int i=0; i<=b-a; i++) {
                answer += arr[i];
            }
        } else if(a > b) {
            arr[0] = b;
            for(int i=1; i<=a-b; i++) {
                arr[i] = b+i;
            }
            for(int i=0; i<=a-b; i++) {
                answer += arr[i];
            }
        }
        return answer;
    }
}