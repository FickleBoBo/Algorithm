package day_06.prms_120907;

import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] ans = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            StringTokenizer st = new StringTokenizer(quiz[i]);

            int x = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int y = Integer.parseInt(st.nextToken());
            st.nextToken();
            int z = Integer.parseInt(st.nextToken());

            if (op.equals("+")) {
                ans[i] = x + y == z ? "O" : "X";
            } else {
                ans[i] = x - y == z ? "O" : "X";
            }
        }

        return ans;
    }
}
