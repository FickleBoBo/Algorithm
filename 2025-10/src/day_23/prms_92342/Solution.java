package day_23.prms_92342;

class Solution {

    private static int[] answer = {-1};
    private static int max = 0;  // 라이언이 어피치를 이긴 점수차

    public int[] solution(int n, int[] info) {
        dfs(new int[11], 0, n, info);

        return answer;
    }

    private static void dfs(int[] selArr, int selIdx, int n, int[] info) {
        // n발을 모두 쏜 경우
        if (selIdx == 11 && n == 0) {
            int result = solve(selArr, info);

            // 현재 점수차보다 더 크게 이기면 바로 갱신하고 현재 점수차와 동일하면 더 작은 점수를 많이 쏜 경우만 갱신
            if (result > max) {
                max = result;
                answer = selArr.clone();
            } else if (result == max && result > 0 && hitMinPoint(selArr)) {
                answer = selArr.clone();
            }

            return;
        }

        // n발을 모두 못 쏜 경우
        if (selIdx == 11) {
            return;
        }

        for (int i = 0; i <= n; i++) {
            selArr[selIdx] = i;
            dfs(selArr, selIdx + 1, n - i, info);
        }
    }

    private static int solve(int[] ryan, int[] apeach) {
        int sum = 0;

        for (int i = 0; i <= 10; i++) {
            if (ryan[i] == 0 && apeach[i] == 0) continue;

            sum = ryan[i] > apeach[i] ? sum + (10 - i) : sum - (10 - i);
        }

        return sum;
    }

    private static boolean hitMinPoint(int[] current) {
        for (int i = 10; i >= 0; i--) {
            if (answer[i] < current[i]) {
                return true;
            } else if (answer[i] > current[i]) {
                return false;
            }
        }

        return false;
    }
}
