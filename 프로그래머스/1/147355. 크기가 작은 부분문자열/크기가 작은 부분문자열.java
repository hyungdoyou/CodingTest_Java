import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        char[] arr1 = t.toCharArray();
        char[] arr2 = p.toCharArray();

        for (int i = 0; i < arr1.length - arr2.length + 1; i++) {
            String subString = new String(arr1, i, arr2.length);
            System.out.print(subString);

            if (subString.compareTo(p) <= 0) {
                answer++;
            }
        }

        return answer;
    }
}