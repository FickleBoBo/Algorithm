package day_26.prms_42748;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int s = commands[i][0] - 1;
            int e = commands[i][1] - 1;
            int k = commands[i][2] - 1;

            int[] tmp = new int[e - s + 1];
            System.arraycopy(array, s, tmp, 0, tmp.length);
            Arrays.sort(tmp);

            ans[i] = tmp[k];
        }

        return ans;
    }
}
