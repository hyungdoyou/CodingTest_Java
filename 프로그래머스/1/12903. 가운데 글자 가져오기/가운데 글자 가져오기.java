class Solution {
    public String solution(String s) {
        String answer = "";
        System.out.println(s.length());
        System.out.println(s.length()/2);

        if(s.length() % 2 == 0) {
            answer = s.substring(s.length()/2-1 , s.length()/2+1);
        } else if(s.length() % 2 != 0) {
            answer = s.substring(s.length()/2 , s.length()/2+1);
        }
        return answer;
    }
}