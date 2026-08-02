package day_26.prms_152996;

import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int w : weights) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        long ans = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int k = e.getKey();
            long v = e.getValue();

            ans += v * (v - 1) / 2;  // 같은 거리에 위치하는 경우
            ans += v * map.getOrDefault(k * 2, 0);  // 4m, 2m에 위치하는 경우
            if (k % 2 == 0) ans += v * map.getOrDefault(k * 3 / 2, 0);  // 3m, 2m에 위치하는 경우
            if (k % 3 == 0) ans += v * map.getOrDefault(k * 4 / 3, 0);  // 4m, 3m에 위치하는 경우
        }

        return ans;
    }
}
