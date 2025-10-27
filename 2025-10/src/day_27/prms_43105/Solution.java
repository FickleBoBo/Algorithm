package day_27.prms_43105;

class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;

        int[][] dp = new int[1 + len][1 + len];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i - 1][j - 1];
            }
        }

        int answer = 0;
        for (int n : dp[len]) {
            answer = Math.max(answer, n);
        }


        return answer;
    }
}
