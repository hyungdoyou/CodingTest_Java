class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        int cnt = 0;
        char[] arr = s.toCharArray();
        if(s.length() == 4 || s.length() == 6) {
            for(int i=0; i<s.length(); i++) {
                if(arr[i]>=48 && arr[i]<=57) {
                     answer = true;
                } else if(arr[i] > 57) {
                    answer=false;
                    break;
                }
            }
        }
        return answer;
    } 
}
