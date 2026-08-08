package day_07.leet_347;

import java.util.*;

class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[1 + nums.length];
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            bucket[e.getValue()].add(e.getKey());
        }

        int[] ans = new int[k];
        int idx = 0;

        for (int i = bucket.length - 1; i >= 1; i--) {
            for (int x : bucket[i]) {
                ans[idx++] = x;
                if (idx == k) return ans;
            }
        }

        return ans;
    }
}
