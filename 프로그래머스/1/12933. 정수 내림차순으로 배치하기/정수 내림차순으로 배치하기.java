class Solution {
    public long solution(long n) {
        String answer = "";
        String str = Long.toString(n);
        long[] arr = new long[str.length()];
        long temp;
        for(int i=0; i<arr.length; i++) {
            arr[i] = n % 10;
            n /= 10;
        }
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] > arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i=0; i<arr.length; i++) {
            answer += arr[i];
        }
        return Long.parseLong(answer);
    }
}