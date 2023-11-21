class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p = s.length() - s.replace("p","").length() - s.replace("P","").length();
        int y = s.length() - s.replace("y","").length() - s.replace("Y","").length();
        if(p == y) {
            answer = true;
        } else if(p != y) {
            answer = false;
        } else {
            answer = true;
        }
        return answer;
    }
}