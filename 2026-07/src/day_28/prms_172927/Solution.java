package day_28.prms_172927;

class Solution {

    static int ans = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        int[][] cost = new int[(minerals.length + 4) / 5][3];

        for (int i = 0; i < minerals.length; i++) {
            String mineral = minerals[i];

            if (mineral.equals("diamond")) {
                cost[i / 5][0] += 1;
                cost[i / 5][1] += 5;
                cost[i / 5][2] += 25;
            } else if (mineral.equals("iron")) {
                cost[i / 5][0] += 1;
                cost[i / 5][1] += 1;
                cost[i / 5][2] += 5;
            } else {
                cost[i / 5][0] += 1;
                cost[i / 5][1] += 1;
                cost[i / 5][2] += 1;
            }
        }

        dfs(0, picks[0] + picks[1] + picks[2], 0, picks, cost);

        return ans;
    }

    static void dfs(int idx, int maxLen, int sum, int[] picks, int[][] cost) {
        if (idx == maxLen || idx == cost.length) {
            ans = Math.min(ans, sum);
            return;
        }

        if (picks[0] > 0) {
            picks[0]--;
            dfs(idx + 1, maxLen, sum + cost[idx][0], picks, cost);
            picks[0]++;
        }

        if (picks[1] > 0) {
            picks[1]--;
            dfs(idx + 1, maxLen, sum + cost[idx][1], picks, cost);
            picks[1]++;
        }

        if (picks[2] > 0) {
            picks[2]--;
            dfs(idx + 1, maxLen, sum + cost[idx][2], picks, cost);
            picks[2]++;
        }
    }
}
