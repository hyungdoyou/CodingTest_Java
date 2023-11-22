class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        for(int i=0; i<1000; i++) {
            if("Kim".equals(seoul[i])) {
                answer = "김서방은 " + i +"에 있다";
                break;
            }
        }
        return answer;
    }
}