package day_01.prms_148652;

class Solution {

    // n번째 유사 칸토어 비트열의 1의 개수를 저장하는 dp 배열
    private static final long[] dp = new long[1 + 20];

    // dp 배열 초기화
    static {
        dp[0] = 1L;
        for (int i = 1; i <= 20; i++) {
            dp[i] = dp[i - 1] * 4;
        }
    }

    public int solution(int n, long l, long r) {
        // 1 ~ r 구간에서 1 ~ l-1 구간의 1의 개수를 빼면 l ~ r 구간의 1의 개수가 됨
        return (int) (dfs(n, r - 1) - dfs(n, l - 2));
    }

    private static long dfs(int n, long range) {
        // range는 0 이상인 정수여야 유효한 범위
        if (range < 0) return 0;

        // 0번째 유사 칸토어 비트열까지 오면 어차피 1이 됨
        if (n == 0) return dp[0];

        // n이 하나 작은 유사 칸토어 비트열의 길이로 현재 유사 칸토어 비트열의 한 블록의 크기와 같음
        long size = (long) Math.pow(5, n - 1);

        // 블록 4개 이상을 차지할 경우 n이 하나 작은 유사 칸토어 비트열의 1의 개수 * 3 + 남은 구간 더하기
        if (range >= size * 4) {
            return dp[n - 1] * 3 + dfs(n - 1, range % size);
        }

        // 블록 3개 이상을 차지할 경우 n이 하나 작은 유사 칸토어 비트열의 1의 개수 * 2 + 남은 구간 더하기
        if (range >= size * 3) {
            return dp[n - 1] * 2 + dfs(n - 1, range % size);
        }

        // 블록 2개 이상을 차지할 경우 n이 하나 작은 유사 칸토어 비트열의 1의 개수 * 2
        if (range >= size * 2) {
            return dp[n - 1] * 2;
        }

        // 블록 1개 이상을 차지할 경우 n이 하나 작은 유사 칸토어 비트열의 1의 개수 + 남은 구간 더하기
        if (range >= size) {
            return dp[n - 1] + dfs(n - 1, range % size);
        }

        // 모두 해당하지 않으면 그냥 n이 하나 작은 유사 칸토어 비트열에서 계산
        return dfs(n - 1, range % size);
    }
}
