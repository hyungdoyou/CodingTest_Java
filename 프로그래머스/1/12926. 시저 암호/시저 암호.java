class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        
        for(int i=0; i<s.length(); i++) {
            if(arr[i] == ' ') {
                arr[i] = ' ';
            } else if ( (int)arr[i] >= 65 & (int)arr[i] <= 90) {
                if( (int)arr[i] + n > 90 ) {
                    arr[i] = (char)((int)arr[i] + n - 26);
                } else {
                    arr[i] = (char)((int)arr[i] + n);
                }
            } else if( (int)arr[i] >= 97 & (int)arr[i] <= 122) {
                if( (int)arr[i] + n > 122 ) {
                    arr[i] = (char)((int)arr[i] + n - 26);
                } else {
                    arr[i] = (char)((int)arr[i] + n);
                }
            }  
            answer += arr[i];
        }
        return answer;
    }
}