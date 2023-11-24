class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int[] cnt = new int[right - left + 1];
        int[] result = new int[right - left + 1];
        for (int i = 0; i < right - left + 1; i++) {
            result[i] = left + i;
        }
        for (int i = 0; i < right - left + 1; i++) {
            for (int j = 1; j <= result[i]; j++) {
                if (result[i] % j == 0) {
                    cnt[i] += 1;
                }
            }
        }
        for (int i = 0; i < right - left + 1; i++) {
            if (cnt[i] % 2 == 0) {
                answer += result[i];
            } else {
                answer -= result[i];
            }
        }
        return answer;
    }
}