class Solution {
    public int solution(int[] numbers) {
        int answer;
        int totalNum = 0;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 0 || numbers[i] == 1 || numbers[i] == 2 || numbers[i] == 3 
              || numbers[i] == 4 || numbers[i] == 5 || numbers[i] == 6 || numbers[i] == 7
              || numbers[i] == 8 || numbers[i] == 9) {
                totalNum += numbers[i];
            }
        }
        answer = 45 - totalNum;
        return answer;
    }
}