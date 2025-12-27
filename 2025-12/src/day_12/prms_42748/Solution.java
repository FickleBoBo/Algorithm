package day_12.prms_42748;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int k = commands[i][2] - 1;

            int[] tmp = new int[end - start + 1];
            System.arraycopy(array, start, tmp, 0, tmp.length);
            Arrays.sort(tmp);

            ans[i] = tmp[k];
        }

        return ans;
    }
}
