class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int temp = x;
        int totalNum = 0;
        int[] arr = new int[5];
        for(int i=0; i<5; i++) {
            arr[i] = x % 10;
            x /= 10;
        }
        for(int i=0; i<5; i++) {
            totalNum += arr[i];
        } 
        if(temp % totalNum != 0) {
            answer = false;
        }
        return answer;
    }
}