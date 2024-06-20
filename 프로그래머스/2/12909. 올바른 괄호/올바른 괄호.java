import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        // 문자열 배열로 변환 char은 소문자
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>(); // Stack은 대문자
        
        for(int i=0; i<str.length; i++) {
            if(str[i] == '(') {  // 문자일때는 ''
                stack.push('(');
            } else if(str[i] == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}