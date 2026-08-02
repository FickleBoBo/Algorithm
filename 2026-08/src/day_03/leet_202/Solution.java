package day_03.leet_202;

import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        int res = func(n);
        while (true) {
            if (res == 1) {
                return true;
            } else if (set.contains(res)) {
                return false;
            } else {
                set.add(res);
                res = func(res);
            }
        }
    }

    static int func(int x) {
        int sum = 0;
        while (x > 0) {
            int r = x % 10;
            sum += r * r;
            x /= 10;
        }
        return sum;
    }
}
