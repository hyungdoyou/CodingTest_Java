import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                result.add(arr[i]);
            }
        }

        if (result.isEmpty()) {
            // 결과가 없을 경우 -1을 담은 배열을 반환
            return new int[]{-1};
        } else {
            // 결과가 있을 경우 리스트를 배열로 변환하여 반환
            int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(answer);
            return answer;
        }
    }
}