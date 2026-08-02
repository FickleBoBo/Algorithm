package day_03.prms_84512;

import java.util.*;

class Solution {

    static List<String> list = new ArrayList<>();
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    static char[] sel = new char[5];

    public int solution(String word) {
        for (int i = 1; i <= 5; i++) {
            dfs(0, i);
        }
        list.sort(Comparator.naturalOrder());

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                return i + 1;
            }
        }

        return 0;
    }

    static void dfs(int idx, int len) {
        if (idx == len) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(sel[i]);
            }
            list.add(sb.toString());
            return;
        }

        for (char c : arr) {
            sel[idx] = c;
            dfs(idx + 1, len);
        }
    }
}
