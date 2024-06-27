class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        // 명함은 회전시킬수 있다.
        // 가로를 가장 길게, 세로를 가장 짧게 설정
        
        int max_width = 0;
        int max_height = 0;
        
        // 각각의 명함을 가로가 크고, 세로가 짧게 변경
        for(int i=0; i<sizes.length; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
 
            // 변경한 명함에서 최대 가로와 최대 세로를 구함
            max_width = Math.max(max_width, w);
            max_height = Math.max(max_height, h);
        }
        
        answer = max_width * max_height;
        
        return answer;
    }
}