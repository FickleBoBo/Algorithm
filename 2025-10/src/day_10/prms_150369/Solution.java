package day_10.prms_150369;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int d = 0;  // 배달할 택배 여유 개수
        int p = 0;  // 수거할 택배 여유 개수
        long answer = 0;

        for (int i = n - 1; i >= 0; i--) {
            d -= deliveries[i];  // i번째 집에 배달할 택배 차감
            p -= pickups[i];  // i번째 집에서 수거할 택배 차감

            // 배달 용량이 모자라거나 수거 용량이 모자라면 트럭 왕복 추가
            while (d < 0 || p < 0) {
                d += cap;
                p += cap;
                answer += (i + 1) * 2;
            }
        }

        return answer;
    }
}
