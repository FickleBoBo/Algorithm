package day_26.prms_152996;

import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int w : weights) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        long ans = 0;
        for (int w : map.keySet()) {
            long cnt = map.get(w);

            ans += cnt * (cnt - 1) / 2;  // 같은 거리에 위치하는 경우
            ans += cnt * map.getOrDefault(w * 2, 0);  // 4m, 2m에 위치하는 경우
            if (w % 2 == 0) ans += cnt * map.getOrDefault(w * 3 / 2, 0);  // 3m, 2m에 위치하는 경우
            if (w % 3 == 0) ans += cnt * map.getOrDefault(w * 4 / 3, 0);  // 4m, 3m에 위치하는 경우
        }

        return ans;
    }
}
