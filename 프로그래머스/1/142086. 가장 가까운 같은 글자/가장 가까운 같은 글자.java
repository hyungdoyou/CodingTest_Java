class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()]; 
        char[] arr = s.toCharArray();
        answer[0] = -1;
        int diff = -1;
        
        for(int i=1; i<arr.length; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] == arr[j]) {
                    diff = j;
                }
            }
            if(diff != -1) {
                answer[i] = i-diff;
                diff = -1;
            } else if(diff == -1) {
                answer[i] = -1;
                diff = -1;
            }
        }
        return answer;
    }
}