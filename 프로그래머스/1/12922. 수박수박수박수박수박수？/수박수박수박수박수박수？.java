class Solution {
    public String solution(int n) {
        String answer = "";
        String[] result = new String[n];
        for(int i=0; i<n; i+=2) {
            result[i] = "수"; 
        }
        for(int i=1; i<n; i+=2) {
            result[i] = "박";
        }
        for(int i=0; i<n; i++) {
            answer += result[i];
        }
        return answer;
    }
}