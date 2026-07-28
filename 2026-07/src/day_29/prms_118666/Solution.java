package day_29.prms_118666;

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            char t1 = survey[i].charAt(0);
            char t2 = survey[i].charAt(1);
            int c = choices[i];

            if (c == 1) {
                map.put(t1, map.getOrDefault(t1, 0) + 3);
            } else if (c == 2) {
                map.put(t1, map.getOrDefault(t1, 0) + 2);
            } else if (c == 3) {
                map.put(t1, map.getOrDefault(t1, 0) + 1);
            } else if (c == 5) {
                map.put(t2, map.getOrDefault(t2, 0) + 1);
            } else if (c == 6) {
                map.put(t2, map.getOrDefault(t2, 0) + 2);
            } else if (c == 7) {
                map.put(t2, map.getOrDefault(t2, 0) + 3);
            }
        }

        String ans = "";
        if (map.getOrDefault('R', 0) >= map.getOrDefault('T', 0)) {
            ans += "R";
        } else {
            ans += "T";
        }

        if (map.getOrDefault('C', 0) >= map.getOrDefault('F', 0)) {
            ans += "C";
        } else {
            ans += "F";
        }

        if (map.getOrDefault('J', 0) >= map.getOrDefault('M', 0)) {
            ans += "J";
        } else {
            ans += "M";
        }

        if (map.getOrDefault('A', 0) >= map.getOrDefault('N', 0)) {
            ans += "A";
        } else {
            ans += "N";
        }

        return ans;
    }
}
