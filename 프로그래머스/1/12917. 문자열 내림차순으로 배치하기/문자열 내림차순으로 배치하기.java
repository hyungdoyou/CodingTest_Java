class Solution {
    public String solution(String s) {
        char temp;
        String answer = "";
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for(int i=0; i<arr.length; i++) {
            answer += arr[i];
        }
        return answer;
        
    }
}