package day_18.prms_42576;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        // 참여한 선수 Map에 저장
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 완주한 선수 정보로 Map 갱신
        for (String c : completion) {
            map.compute(c, (k, v) -> v == 1 ? null : v - 1);
        }

        // 하나 남은 key 반환
        return map.keySet().iterator().next();
    }
}
