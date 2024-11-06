import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Boolean> map = new HashMap<>();
        
        // 모든 전화번호를 해시맵에 저장
        for (String phone : phone_book) {
            map.put(phone, true);
        }
        
        // 각 전화번호의 접두사가 해시맵에 존재하는지 확인
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (map.containsKey(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}