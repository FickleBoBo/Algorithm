package day_16.prms_150365;

class Solution {

    private static char[] arr;
    private static final char[] sel = {'d', 'l', 'r', 'u'};  // 오름차순으로 방향 설정
    private static String answer = "";

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        if (isImpossible(k, x, y, r, c)) return "impossible";

        arr = new char[k];
        permutation(0, k, n, m, x, y, r, c);

        return answer;
    }

    // 두 좌표간 거리 반환
    private static int distance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }

    // 두 좌표간 거리가 남은 이동 횟수보다 크거나 남은 이동 횟수 - 거리가 짝수가 아니면 불가능한 상황
    private static boolean isImpossible(int times, int x, int y, int r, int c) {
        return distance(x, y, r, c) > times || (times - distance(x, y, r, c)) % 2 == 1;
    }

    private static void permutation(int selIdx, int len, int n, int m, int x, int y, int r, int c) {
        // 한번이라도 경로를 구하면 가지치기
        if (!answer.isEmpty()) return;

        // 현재 상황에서 불가능한 경로면 가지치기
        if (isImpossible(len - selIdx, x, y, r, c)) return;

        if (selIdx == len) {
            // 목적지에 도착하지 못하면 리턴
            if (!(x == r && y == c)) return;

            StringBuilder sb = new StringBuilder();
            for (char dir : arr) {
                sb.append(dir);
            }

            answer = sb.toString();
            return;
        }

        // 다음 방향이 이동가능한 방향이면 탐색
        for (char dir : sel) {
            if (dir == 'd') {
                if (x == n) continue;

                arr[selIdx] = dir;
                permutation(selIdx + 1, len, n, m, x + 1, y, r, c);
            } else if (dir == 'l') {
                if (y == 1) continue;

                arr[selIdx] = dir;
                permutation(selIdx + 1, len, n, m, x, y - 1, r, c);
            } else if (dir == 'r') {
                if (y == m) continue;

                arr[selIdx] = dir;
                permutation(selIdx + 1, len, n, m, x, y + 1, r, c);
            } else {
                if (x == 1) continue;

                arr[selIdx] = dir;
                permutation(selIdx + 1, len, n, m, x - 1, y, r, c);
            }
        }
    }
}
