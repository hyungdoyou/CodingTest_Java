class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int[] result = new int[absolutes.length];
        for(int i=0; i<absolutes.length; i++) {
            if(signs[i] == true) {
                result[i] = absolutes[i] * 1;
            } else if(signs[i] == false) {
                result[i] = absolutes[i] * (-1);
            }
        }
        for(int i=0; i<absolutes.length; i++) {
            answer += result[i];
        }
        
        return answer;
    }
}