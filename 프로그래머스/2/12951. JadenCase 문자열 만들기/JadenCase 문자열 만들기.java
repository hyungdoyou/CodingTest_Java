class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 문자열을 띄어쓰기 단위로 문자로 나눠 배열에 저장
        String[] str = s.split(" ");
        
        // 각 배열의 첫번째 글자가 숫자가 아니라면 대문자로 변경, 나머지 문자는 소문자로 변경
        for(int i=0; i<str.length; i++) {
            String now = str[i];
            if(str[i].length() == 0) {
                answer += " ";
            } else {
            answer += now.substring(0,1).toUpperCase();
            answer += now.substring(1,now.length()).toLowerCase();
            answer += " ";                
            }

        }
        
        if(s.substring(s.length()-1, s.length()).equals(" ")) {
            return answer;
        }
        
        return answer.substring(0, answer.length()-1);
    }
}