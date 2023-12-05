class Solution {
    public int solution(String s) {
        Integer answer = 0;
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven","eight","nine"};
        for(int i=0; i<10; i++) {
            s = s.replace(str[i], Integer.toString(i));
        }
        answer = Integer.valueOf(s);
        return answer;
    }
}