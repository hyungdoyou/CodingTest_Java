import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3]; // 맞힌 개수 담은 배열
        
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == answer1[i%5]) score[0]++;
            if(answers[i] == answer2[i%8]) score[1]++;
            if(answers[i] == answer3[i%10]) score[2]++;
        }
        
        // 가장 많이 맞춘 개수 구하기
        int max_score = 0;
        for(int i=0; i<score.length; i++) {
            if(max_score < score[i]) {
                max_score = score[i];
            }
        }
        
        // 정답 출력을 위한 리스트 생성
        List<Integer> list = new ArrayList<>();
        
        // 가장 많이 맞춘 사람 리스트에 추가
        for(int i=0; i<score.length; i++) {
            if(max_score == score[i]) {
                list.add(i+1);
            }
        }
        
        return list;
    }
}