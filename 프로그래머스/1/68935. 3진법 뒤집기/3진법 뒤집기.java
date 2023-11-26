import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        while(n > 0) {
            arrList.add(n%3);
            n /= 3;
        }
        int[] arr= new int[arrList.size()];
        arr[arrList.size()-1] = 1;
        for(int i=1; i<arrList.size(); i++) {
            arr[arrList.size()-i-1] = arr[arrList.size()-i] * 3;
        }
        for(int i=0; i<arrList.size(); i++) {
            answer += arrList.get(i) * arr[i];
        }
        return answer;
    }
}