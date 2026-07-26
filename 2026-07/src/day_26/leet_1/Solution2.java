package day_26.leet_1;

import java.util.*;

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && nums[i] * 2 == target) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && nums[i] * 2 != target) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }

        return null;
    }
}
