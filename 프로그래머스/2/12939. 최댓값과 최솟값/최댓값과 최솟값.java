class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        String min = str[0];
        String max = str[0];
        for(int i=1; i<str.length; i++) {
            if(Integer.parseInt(str[i]) > Integer.parseInt(max)) {
                    max = str[i];
            }
        }
            
        for(int i=1; i<str.length; i++) {
            if(Integer.parseInt(str[i]) < Integer.parseInt(min)) {
                    min = str[i];
            }
        }
        answer = min + " "+ max;
        return answer;
        
    }
}