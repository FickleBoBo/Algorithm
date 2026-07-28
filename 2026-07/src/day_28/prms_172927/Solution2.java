package day_28.prms_172927;

import java.util.*;

class Solution2 {
    public int solution(int[] picks, String[] minerals) {
        int pickCnt = picks[0] + picks[1] + picks[2];
        int[][] cnt = new int[pickCnt][3];

        for (int i = 0; i < Math.min(minerals.length, pickCnt * 5); i++) {
            String mineral = minerals[i];

            if (mineral.equals("diamond")) {
                cnt[i / 5][0]++;
            } else if (mineral.equals("iron")) {
                cnt[i / 5][1]++;
            } else {
                cnt[i / 5][2]++;
            }
        }

        Arrays.sort(cnt, (o1, o2) -> {
            if (o1[0] != o2[0]) return Integer.compare(o2[0], o1[0]);
            return Integer.compare(o2[1], o1[1]);
        });

        int ans = 0;
        for (int[] arr : cnt) {
            if (picks[0] > 0) {
                ans += arr[0] + arr[1] + arr[2];
                picks[0]--;
            } else if (picks[1] > 0) {
                ans += arr[0] * 5 + arr[1] + arr[2];
                picks[1]--;
            } else if (picks[2] > 0) {
                ans += arr[0] * 25 + arr[1] * 5 + arr[2];
                picks[2]--;
            } else {
                break;
            }
        }

        return ans;
    }
}
