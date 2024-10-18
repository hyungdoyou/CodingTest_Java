import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // 의상 종류별로 개수를 세기 위한 맵
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
        // 각 종류별 의상 수를 카운트
        for (String[] cloth : clothes) {
            String type = cloth[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }
        
        // 모든 조합의 수를 계산
        int answer = 1;
        for (int count : clothesMap.values()) {
            // 각 종류에서 선택하는 경우의 수 (입지 않는 경우 포함해서 +1)
            answer *= (count + 1);
        }
        
        // 아무것도 입지 않는 경우를 제외
        return answer - 1;
    }
}
