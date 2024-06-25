// begin 과 문자 1개만 차이나는 단어 찾아나가기
class Solution {
    boolean[] visited;
    int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        
        // 방문여부 배열
        visited = new boolean[words.length];
        for(int i=0; i<visited.length; i++) {
            visited[i] = false;
        }

        // dfs
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, Integer cnt) {
        
        // 만약 taget 단어에 도달하면 재귀함수 종료
        if(begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(visited[i] == true) {
                continue;
            }
            
            int check = 0; // 글자수가 몇개 다른지 체크
            
            for(int j=0; j<begin.length(); j++) {
                if(begin.charAt(j) != words[i].charAt(j)) {
                    check++;
                }
            }
            
            if(check == 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt+1);
                visited[i] = false; // 백트래킹(다른 경로에서 해당 단어를 사용할 수 있도록 해제)
            }
        }
    }
}