package day_27.prms_138476;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());

        int sum = 0;
        int ans = 0;
        for (int v : list) {
            sum += v;
            ans++;

            if (sum >= k) break;
        }

        return ans;
    }
}
