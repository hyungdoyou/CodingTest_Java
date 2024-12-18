class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");
        
        int min = Integer.parseInt(arr[0]);
        
        for(int i = 1; i < arr.length; i++) {
            if(Integer.parseInt(arr[i]) < min) {
                min = Integer.parseInt(arr[i]);
            }
        }
        
        int max = Integer.parseInt(arr[0]);
        
        for(int i = 1; i < arr.length; i++) {
            if(Integer.parseInt(arr[i]) > max) {
                max = Integer.parseInt(arr[i]);
            }
        }
        
        answer = min + " " + max;

        return answer;
    }
}