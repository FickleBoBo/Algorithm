package day_03.prms_1845;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // map에 N / 2 종류 이상이 있으면 N / 2 종류를 고를 수 있고, map에 N / 2 종류 미만이 있으면 모든 종류 수만큼 고를 수 있다
        return Math.min(nums.length / 2, map.size());
    }
}
