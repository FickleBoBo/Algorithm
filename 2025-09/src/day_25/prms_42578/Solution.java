package day_25.prms_42578;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // key에 의상의 종류, value에 해당 종류인 의상의 수
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        // 해당 의상의 종류가 N개 있을 때 안 고르거나 N개 중 하나를 고를 수 있으므로 종류마다 종류의 수 + 1 가지 경우 존재
        int answer = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue() + 1;
        }

        // 아무 의상도 선택하지 않은 한 가지 경우 제외
        return answer - 1;
    }
}
