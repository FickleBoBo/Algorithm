package day_16.prms_138476;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());  // 같은 크기의 귤의 개수에 대해 내림차순 정렬

        int sum = 0;
        int answer = 0;
        for (int v : list) {
            sum += v;
            answer++;

            if (sum >= k) break;
        }

        return answer;
    }
}
