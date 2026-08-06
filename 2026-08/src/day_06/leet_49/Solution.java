package day_06.leet_49;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        out:
        for (String str : strs) {
            for (List<String> list : ans) {
                if (list.get(0).length() == str.length() && isAnagram(list.get(0), str)) {
                    list.add(str);
                    continue out;
                }
            }

            List<String> list = new ArrayList<>();
            list.add(str);
            ans.add(list);
        }

        return ans;
    }

    static boolean isAnagram(String s1, String s2) {
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            cnt[c - 'a']--;
        }

        for (int x : cnt) {
            if (x != 0) return false;
        }

        return true;
    }
}
