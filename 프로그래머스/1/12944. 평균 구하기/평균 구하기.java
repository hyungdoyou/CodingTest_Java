class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int totalSum = 0;
        for(int i=0; i<arr.length; i++) {
            totalSum += arr[i]; 
        }
        answer = totalSum / (double)arr.length;
        return answer;
    }
}