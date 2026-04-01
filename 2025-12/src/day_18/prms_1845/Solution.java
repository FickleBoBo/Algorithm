package day_18.prms_1845;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        return Math.min(set.size(), nums.length / 2);
    }
}
