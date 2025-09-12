package day_12.prms_181187;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        // 1사분면에 해당하는 좌표 수만 계산
        for (long x = 1; x <= r2; x++) {
            int max = (int) Math.sqrt((long) r2 * r2 - x * x);
            int min = (int) Math.ceil(Math.sqrt((long) r1 * r1 - x * x));
            answer += max - min + 1;
        }

        // 전체 좌표 수 반환
        return answer * 4;
    }
}
