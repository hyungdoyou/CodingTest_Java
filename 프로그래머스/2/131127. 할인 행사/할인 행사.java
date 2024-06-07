public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 할인 목록에서 10일 연속 구간을 검사하는 루프
        for (int i = 0; i <= discount.length - 10; i++) {
            int cntday = 0; // 조건을 만족하는 물품의 종류 수를 세기 위한 변수

            // 원하는 물품 목록을 순회하는 루프
            for (int j = 0; j < want.length; j++) {
                int cnt = 0; // 각 물품이 할인 목록에서 몇 번 나타나는지 세는 변수

                // 현재 10일 구간을 순회하는 루프
                for (int k = i; k < i + 10; k++) {
                    // 현재 물품이 할인 목록에 나타나면 cnt 증가
                    if (discount[k].equals(want[j])) {
                        cnt++;
                    }
                }

                // 현재 물품이 필요한 수량보다 적게 나타나면 내부 루프 종료
                if (cnt < number[j]) {
                    break;
                } else {
                    cntday++; // 필요한 수량만큼 나타나면 cntday 증가
                }
            }

            // 모든 원하는 물품이 필요한 수량만큼 나타났으면 answer 증가
            if (cntday == want.length) {
                answer++;
            }
        }

        return answer;
    }
}